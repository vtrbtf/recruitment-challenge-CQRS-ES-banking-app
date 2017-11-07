package com.vtrbtf.minibank.application.query.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.vtrbtf.minibank.application.query.client.repository.view.ClientView;
import com.vtrbtf.minibank.application.query.client.repository.view.CompanyView;
import com.vtrbtf.minibank.application.query.client.repository.view.PersonView;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static java.util.Arrays.*;
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
        ClassModel<ClientView> userModel = ClassModel.builder(ClientView.class).enableDiscriminator(true).build();
        ClassModel<PersonView> freeUserModel = ClassModel.builder(PersonView.class).enableDiscriminator(true).build();
        ClassModel<CompanyView> subscriberUserModel = ClassModel.builder(CompanyView.class).enableDiscriminator(true).build();

        return fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).conventions(asList(Conventions.ANNOTATION_CONVENTION, Conventions.CLASS_AND_PROPERTY_CONVENTION)).register(userModel, freeUserModel, subscriberUserModel).build()));
    }
}
