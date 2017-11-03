package com.vtrbtf.minibank.account.event;

import java.math.BigDecimal;

public class AccountDeposited extends AccountTransactionEvent {
    public AccountDeposited() { }

    public AccountDeposited(String id, String name, BigDecimal value, BigDecimal balance) {
        super(id, name, value, balance);
    }
}
