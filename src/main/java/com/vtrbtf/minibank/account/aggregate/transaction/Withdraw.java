package com.vtrbtf.minibank.account.aggregate.transaction;

import com.vtrbtf.minibank.account.application.event.AccountWithdrew;

import java.math.BigDecimal;


public class Withdraw extends Transaction {
    public Withdraw(String name, BigDecimal value) {
        super(name, value);
    }

    public Withdraw(AccountWithdrew event) {
        this(event.getName(), event.getValue());
    }
}
