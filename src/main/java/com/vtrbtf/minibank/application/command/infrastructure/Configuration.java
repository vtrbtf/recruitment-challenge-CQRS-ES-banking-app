package com.vtrbtf.minibank.application.command.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.vtrbtf.minibank.aggregate.account.Account;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    public static final String EVENTS_DB = "minibank_events_db";


    @Bean
    public Serializer serializer() {
        return new JacksonSerializer();
    }

    @Bean
    public CommandBus commandBus() {
        return new SimpleCommandBus();
    }

    @Bean
    public MongoClient mongoEventStorageClient(@Value("${events.db_uri}") String URI) {
        return new MongoClient(new MongoClientURI(URI));
    }

    @Bean
    public MongoTemplate mongoTemplate(@Autowired @Qualifier("mongoEventStorageClient") MongoClient client) {
        return new DefaultMongoTemplate(client, EVENTS_DB, "minibank_events", "minibank_snapshots");
    }

    @Bean
    public EventStorageEngine eventStorageEngine(@Autowired MongoTemplate mongoTemplate) {
        return new MongoEventStorageEngine(serializer(), null, mongoTemplate, new DocumentPerCommitStorageStrategy());
    }

    @Bean
    public EventStore eventBus(@Autowired EventStorageEngine eventStorageEngine) {
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
