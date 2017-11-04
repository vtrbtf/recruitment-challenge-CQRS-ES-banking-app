package com.vtrbtf.minibank.application.query.model.client.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.vtrbtf.minibank.aggregate.account.events.AccountOpened;
import com.vtrbtf.minibank.aggregate.account.events.AccountTransactionEvent;
import com.vtrbtf.minibank.aggregate.client.events.ClientEnrolled;
import com.vtrbtf.minibank.application.query.infrastructure.Configuration;
import com.vtrbtf.minibank.application.query.model.account.repository.view.TransactionView;
import com.vtrbtf.minibank.application.query.model.client.repository.view.ClientView;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

@Repository
@Value @NonFinal
public class ClientRepository {
    MongoCollection<ClientView> collection;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ClientRepository(@Qualifier("mongoDomainClient") MongoClient client) {
        collection = client.getDatabase(Configuration.DOMAIN_DB).getCollection("client", ClientView.class);
    }

    public void save(ClientView view){
        collection.insertOne(view);
    }

    public ClientView get(String id){
        return collection.find(eq("_id", id)).first();
    }
}
