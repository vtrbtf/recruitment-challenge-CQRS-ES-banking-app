package com.vtrbtf.minibank.aggregate.client.account.transaction;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountWithdrew;

import java.math.BigDecimal;


public class Withdraw extends Transaction {
    public Withdraw(String name, BigDecimal value) {
        super(name, value);
    }

    public Withdraw(AccountWithdrew event) {
        this(event.getName(), event.getValue());
    }
}
