package com.vtrbtf.minibank;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.vtrbtf.minibank.account.aggregate.Account;
import org.axonframework.commandhandling.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.documentpercommit.DocumentPerCommitStorageStrategy;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@SpringBootApplication(scanBasePackages = "com.vtrbtf.minibank")
public class MinibankApplication {

	public static final String EVENTS_DB = "minibank_events_db";
	public static final String DOMAIN_DB = "minibank";

	public static void main(String[] args) {
		SpringApplication.run(MinibankApplication.class, args);
	}

	@Bean
	public Serializer serializer() {
		return new JacksonSerializer();
	}

	@Bean
	public CommandBus commandBus() {
		return new SimpleCommandBus();
	}

	@Bean
	public MongoClient mongoEventStorageClient(@Value("#{events.db_uri}") String URI) {
		return new MongoClient(new MongoClientURI(URI));
	}

	@Bean
	public MongoClient mongoDomainClient(@Value("#{domain.db_uri}") String URI) {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		return new MongoClient(new MongoClientURI(URI, MongoClientOptions.builder().codecRegistry(pojoCodecRegistry)));
	}

	@Bean
	public MongoTemplate mongoTemplate(@Autowired @Qualifier("mongoEventStorageClient") MongoClient client) {
		return new DefaultMongoTemplate(client, EVENTS_DB, "minibank_events", "minibank_snapshots");
	}

	@Bean
	public EventStorageEngine eventStorageEngine(@Autowired MongoTemplate mongoTemplate) {
		return new MongoEventStorageEngine(serializer(), null, mongoTemplate, new DocumentPerCommitStorageStrategy());
	}

	@Bean(name = "eventBus")
	public EventStore eventStore(@Autowired EventStorageEngine eventStorageEngine) {
		return new EmbeddedEventStore(eventStorageEngine);
	}

	@Bean
	public EventSourcingRepository<Account> repository(@Autowired EventStore eventStore) {
		return new EventSourcingRepository<>(Account.class, eventStore);
	}

	@Bean
	public AggregateAnnotationCommandHandler<Account> handler(@Autowired EventSourcingRepository repository) {
		return new AggregateAnnotationCommandHandler<>(Account.class, repository);
	}
}