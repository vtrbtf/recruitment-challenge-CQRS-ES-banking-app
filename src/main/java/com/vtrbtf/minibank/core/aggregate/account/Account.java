package com.vtrbtf.minibank.core.aggregate.account;

import com.vtrbtf.minibank.core.aggregate.account.transaction.Deposit;
import com.vtrbtf.minibank.core.aggregate.account.transaction.Transaction;
import com.vtrbtf.minibank.core.aggregate.account.transaction.Withdraw;
import lombok.Value;

import java.util.List;

@Value
public class Account {
    String id;
    String name;
    String description;
    List<Transaction> transactions;

    public void deposit(Deposit deposit) {
        transactions.add(deposit);
    }

    public void withdraw(Withdraw withdraw) {
        transactions.add(withdraw);
    }
}
