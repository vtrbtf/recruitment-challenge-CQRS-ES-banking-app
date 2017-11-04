package com.vtrbtf.minibank.application.query.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@org.springframework.context.annotation.Configuration
public class Configuration {
    public static final String DOMAIN_DB = "minibank";

    @Bean
    public MongoClient mongoDomainClient(@Value("${domain.db_uri}") String URI) {
        return new MongoClient(new MongoClientURI(URI, MongoClientOptions.builder().codecRegistry(fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build())))));
    }
}
