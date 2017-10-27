package com.vtrbtf.minibank.core.domain.account;

import com.vtrbtf.minibank.core.domain.transaction.Transaction;
import lombok.Value;

import java.util.List;

@Value
public class Account {
    String id;
    String name;
    List<Transaction> transactions;
}
