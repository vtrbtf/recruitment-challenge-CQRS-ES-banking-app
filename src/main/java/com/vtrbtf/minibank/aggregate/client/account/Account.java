package com.vtrbtf.minibank.aggregate.client.account;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountDeposited;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountOpened;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountWithdrew;
import com.vtrbtf.minibank.aggregate.client.account.transaction.Deposit;
import com.vtrbtf.minibank.aggregate.client.account.transaction.Transaction;
import com.vtrbtf.minibank.aggregate.client.account.transaction.Withdraw;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;


@Value
public class Account {
    String accountId;
    AccountType type;
    List<Transaction> transactions;

    private Account(String accountId, AccountType type, List<Transaction> transactions) {
        this.accountId = accountId;
        this.type = type;
        this.transactions = transactions;
    }

    public static Account open(AccountOpened event) {
        return new Account(event.getAccountId(), event.getType(), new ArrayList<>());
    }

    public String getAccountId() {
        return accountId;
    }

    public void withdraw(AccountWithdrew event) {
        transactions.add(new Withdraw(event));
    }

    public void deposit(AccountDeposited event) {
        transactions.add(new Deposit(event));
    }

    public BigDecimal currentBalance() {
        return BigDecimal.valueOf(transactions.stream().mapToDouble(t -> t.getValue().doubleValue()).sum());
    }

    public BigDecimal projectBalance(BigDecimal projectedTransactionValue) {
        return currentBalance().add(projectedTransactionValue);
    }
}
