package com.vtrbtf.minibank.account.event;

import java.math.BigDecimal;

public class AccountDeposited extends AccountTransactionEvent {
    public AccountDeposited(String id, String name, BigDecimal value) {
        super(id, name, value);
    }
}
