package com.vtrbtf.minibank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Account {
    private final String owner;
    private final String type;
    private final List<Transaction> transactions;

    @JsonCreator
    public Account(@JsonProperty("owner") String owner, @JsonProperty("type")String type,
                   @JsonProperty("transactions") List<Transaction> transactions) {
        this.owner = owner;
        this.type = type;
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }
}
