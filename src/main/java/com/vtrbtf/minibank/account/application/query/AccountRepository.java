package com.vtrbtf.minibank.account.application.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.vtrbtf.minibank.MinibankApplication;
import com.vtrbtf.minibank.account.application.query.view.AccountView;
import com.vtrbtf.minibank.account.application.query.view.TransactionView;
import com.vtrbtf.minibank.account.event.AccountOpened;
import com.vtrbtf.minibank.account.event.AccountTransactionEvent;
import lombok.Value;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;

@Repository
@Value
public class AccountRepository {
    MongoCollection<AccountView> collection;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public AccountRepository(MongoClient client) {
        collection = client.getDatabase(MinibankApplication.DOMAIN_DB).getCollection("account", AccountView.class);
    }

    public void save(AccountOpened account){
        collection.insertOne(new AccountView(account));
    }

    public void pushTransaction(AccountTransactionEvent transaction){
        collection.updateOne(eq("_id", transaction.getId()), push("transactions", new TransactionView(transaction)));
    }

    public AccountView get(String id){
        return collection.find(eq("_id", id)).first();
    }
}
