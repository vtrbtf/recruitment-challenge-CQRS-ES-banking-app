package com.vtrbtf.minibank.aggregate.client.account.transaction;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountDeposited;

public class Deposit extends Transaction {
    public Deposit(AccountDeposited event) {
        super(event.getName(), event.getValue());
    }
}
