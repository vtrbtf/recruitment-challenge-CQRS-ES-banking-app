package com.vtrbtf.minibank.account.aggregate.transaction;

import lombok.Value;

import java.math.BigDecimal;

public class Deposit extends Transaction {
    public Deposit(String name, BigDecimal value) {
        super(name, value);
    }
}
