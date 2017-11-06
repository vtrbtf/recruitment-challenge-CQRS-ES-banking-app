package com.vtrbtf.minibank.application.query.client.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.vtrbtf.minibank.application.query.client.repository.view.ClientView;
import com.vtrbtf.minibank.application.query.infrastructure.QuerySideConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;

@Repository
@Value
@NonFinal
public class ClientRepository {
    MongoCollection<ClientView> collection;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ClientRepository(@Qualifier("querySideMongoClient") MongoClient client) {
        collection = client.getDatabase(QuerySideConfiguration.DOMAIN_DB).getCollection("client", ClientView.class);
    }

    public void save(ClientView view) {
        collection.insertOne(view);
    }

    public ClientView get(String id) {
        return collection.find(eq("_id", id)).first();
    }
}
