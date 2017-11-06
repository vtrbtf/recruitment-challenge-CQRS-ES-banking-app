package com.vtrbtf.minibank.application.query.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class QuerySideConfiguration {
    public static final String DOMAIN_DB = "minibank";

    @Bean
    public MongoClient querySideMongoClient(@Value("${domain.db_uri}") String URI) {
        return new MongoClient(new MongoClientURI(URI, options()));
    }

    private MongoClientOptions.Builder options() {
        return MongoClientOptions.builder().
                codecRegistry(codecConfig());
    }

    private CodecRegistry codecConfig() {
        return fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }
}
