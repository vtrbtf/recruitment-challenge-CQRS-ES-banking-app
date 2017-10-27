package com.vtrbtf.minibank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Account {
    private final String id;
    private final String type;
    private final List<Transaction> transactions;

    @JsonCreator
    public Account(@JsonProperty("id") String id, @JsonProperty("type") String type, @JsonProperty("transactions") List<Transaction> transactions) {
        this.id = id;
        this.type = type;
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
