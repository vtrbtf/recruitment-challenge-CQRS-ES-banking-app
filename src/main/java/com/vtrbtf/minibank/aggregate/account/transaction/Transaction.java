package com.vtrbtf.minibank.aggregate.account.transaction;

import com.vtrbtf.minibank.aggregate.account.events.AccountTransactionEvent;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.math.BigDecimal;

@Value
@NonFinal
@RequiredArgsConstructor
public class Transaction {
    String name;
    BigDecimal value;

    public Transaction(AccountTransactionEvent event) {
        name = event.getName();
        value = event.getValue();
    }
}
