package com.vtrbtf.minibank.account.aggregate;

import com.vtrbtf.minibank.account.aggregate.transaction.Transaction;
import lombok.Value;

import java.util.List;

@Value
public class Account {
    String id;
    String name;
    String description;
    List<Transaction> transactions;
}
