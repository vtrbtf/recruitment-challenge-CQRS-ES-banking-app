package com.vtrbtf.minibank.application.command.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandSideConfiguration {

    @Bean
    public MongoClient commandSideMongoClient(@Value("${events.db_uri}") String URI) {
        return new MongoClient(new MongoClientURI(URI));
    }

    @Bean
    public Serializer eventSerializer() {
        return new JacksonSerializer();
    }

}
