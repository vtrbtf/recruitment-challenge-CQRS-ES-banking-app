package com.vtrbtf.minibank.aggregate.client.account.events;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class AccountDeposited extends AccountTransactionEvent {
    public AccountDeposited(String clientId, String accountId, String name, BigDecimal value, BigDecimal balance) {
        super(clientId, accountId, name, value, balance);
    }
}
