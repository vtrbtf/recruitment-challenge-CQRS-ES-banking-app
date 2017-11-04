package com.vtrbtf.minibank.aggregate.account.transaction;

import com.vtrbtf.minibank.aggregate.account.events.AccountDeposited;
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
