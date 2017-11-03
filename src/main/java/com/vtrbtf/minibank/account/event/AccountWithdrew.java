package com.vtrbtf.minibank.account.event;

import java.math.BigDecimal;

public class AccountWithdrew extends AccountTransactionEvent {
    public AccountWithdrew() {}

    public AccountWithdrew(String id, String name, BigDecimal value, BigDecimal balance) {
        super(id, name, value, balance);
    }
}
