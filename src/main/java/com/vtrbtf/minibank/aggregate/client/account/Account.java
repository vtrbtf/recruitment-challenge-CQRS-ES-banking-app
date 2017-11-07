package com.vtrbtf.minibank.aggregate.client.account;

import com.vtrbtf.minibank.aggregate.client.exceptions.ClientException;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountDeposited;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountOpened;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountWithdrew;
import com.vtrbtf.minibank.aggregate.client.account.transaction.Deposit;
import com.vtrbtf.minibank.aggregate.client.account.transaction.Transaction;
import com.vtrbtf.minibank.aggregate.client.account.transaction.Withdraw;
import lombok.Value;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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

    public void verifyBalanceAfterWithdraw(BigDecimal value) {
        if (isNegativeNumber(projectBalance(value))) {
            throw new ClientException("Not enough money");
        }
    }

    private boolean isNegativeNumber(BigDecimal number) {
        return number.compareTo(BigDecimal.ZERO) < 0;
    }

    private boolean isPositiveNumber(BigDecimal number) {
        return number.compareTo(BigDecimal.ZERO) > 0;
    }

    private void verifyTransactionValue(boolean transactionCriteria, String message) {
        if (!transactionCriteria) {
            throw new ClientException(message);
        }
    }

    public void verifyWithdrawValue(BigDecimal value) {
        verifyTransactionValue(isNegativeNumber(value), "Withdraws should have a negative value");
    }

    public void verifyDepositValue(BigDecimal value) {
        verifyTransactionValue(isPositiveNumber(value), "Deposits should have a positive value");
    }
}
