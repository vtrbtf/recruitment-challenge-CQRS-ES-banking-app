package com.vtrbtf.minibank.account.aggregate.transaction;

import lombok.Value;

import java.math.BigDecimal;


public class Withdraw extends Transaction {
    public Withdraw(String name, BigDecimal value) {
        super(name, value);
    }
}
