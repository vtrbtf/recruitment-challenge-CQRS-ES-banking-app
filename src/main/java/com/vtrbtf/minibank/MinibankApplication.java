package com.vtrbtf.minibank;

import com.mongodb.MongoClient;
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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.vtrbtf.minibank")
public class MinibankApplication {
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
	public MongoClient mongo() {
		return new MongoClient("127.0.0.1", 27017);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new DefaultMongoTemplate(mongo(), "minibank_db", "minibank_events", "minibank_snapshots");
	}

	@Bean
	public EventStorageEngine eventStorageEngine() {
		return new MongoEventStorageEngine(serializer(), null, mongoTemplate(), new DocumentPerCommitStorageStrategy());
	}

	@Bean
	public EventStore eventStore() {
		return new EmbeddedEventStore(eventStorageEngine());
	}

	@Bean
	public EventSourcingRepository<Account> repository() {
		return new EventSourcingRepository<>(Account.class, eventStore());
	}

	@Bean
	public AggregateAnnotationCommandHandler<Account> handler() {
		return new AggregateAnnotationCommandHandler<>(Account.class, repository());
	}
}
