package com.vtrbtf.minibank.application.command.infrastructure;

import com.mongodb.MongoClient;
import com.vtrbtf.minibank.aggregate.client.Client;
import org.axonframework.commandhandling.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.documentpercommit.DocumentPerCommitStorageStrategy;
import org.axonframework.serialization.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandSideAccountConfiguration {
    public static final String EVENTS_DB = "minibank_events_db";

    @Autowired
    @Qualifier("commandSideMongoClient")
    MongoClient client;

    @Autowired
    Serializer serializer;

    @Bean
    public CommandBus commandBus() {
        return new SimpleCommandBus();
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new DefaultMongoTemplate(client, EVENTS_DB, "minibank_events", "minibank_snapshots");
    }

    @Bean
    public EventStorageEngine eventStorageEngine() {
        return new MongoEventStorageEngine(serializer, null, mongoTemplate(), new DocumentPerCommitStorageStrategy());
    }

    @Bean
    public EventStore eventBus() {
        return new EmbeddedEventStore(eventStorageEngine());
    }


    @Bean
    public CommandGateway commandGateway() {
        return new DefaultCommandGateway(commandBus());
    }

    @Bean
    public EventSourcingRepository<Client> eventSourcingRepository() {
        return new EventSourcingRepository<>(Client.class, eventBus());
    }

    @Bean
    public AggregateAnnotationCommandHandler<Client> commandHandler() {
        return new AggregateAnnotationCommandHandler<>(Client.class, eventSourcingRepository());
    }
}
