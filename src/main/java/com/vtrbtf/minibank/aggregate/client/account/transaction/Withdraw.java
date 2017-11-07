package com.vtrbtf.minibank.aggregate.client.account.transaction;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountWithdrew;


public class Withdraw extends Transaction {
    public Withdraw(AccountWithdrew event) {
        super(event.getName(), event.getValue());
    }
}
