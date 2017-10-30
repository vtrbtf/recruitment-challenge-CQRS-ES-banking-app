package com.vtrbtf.minibank.core.aggregate.account.transaction;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Transactions {
    List<Transaction> transactions;

    public Transactions() {
        transactions = new ArrayList<>();
    }
}
