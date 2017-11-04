package com.vtrbtf.minibank.application.query.model.account.repository.view;

import com.vtrbtf.minibank.aggregate.account.events.AccountTransactionEvent;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionView {
    String name;
    BigDecimal value;

    public TransactionView() { }

    public TransactionView(AccountTransactionEvent transaction) {
      name = transaction.getName();
      value = transaction.getValue();
    }
}
