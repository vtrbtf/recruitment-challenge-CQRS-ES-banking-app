package com.vtrbtf.minibank;

import java.util.List;

public class Account {
    private final String id;
    private final String type;
    private final List<Transaction> transactions;

    public Account(String id, String type, List<Transaction> transactions) {
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
