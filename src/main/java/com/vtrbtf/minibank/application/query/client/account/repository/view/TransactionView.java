package com.vtrbtf.minibank.application.query.client.account.repository.view;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountTransactionEvent;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionView {
    String name;
    BigDecimal value;

    public TransactionView(AccountTransactionEvent transaction) {
        name = transaction.getName();
        value = transaction.getValue();
    }
}
