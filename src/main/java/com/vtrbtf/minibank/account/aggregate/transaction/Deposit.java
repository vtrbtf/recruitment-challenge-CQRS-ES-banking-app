package com.vtrbtf.minibank.account.aggregate.transaction;

import com.vtrbtf.minibank.account.application.event.AccountDeposited;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class Deposit extends Transaction {
    public Deposit(String name, BigDecimal value) {
        super(name, value);
    }

    public Deposit(AccountDeposited event) {
        this(event.getName(), event.getValue());
    }
}
