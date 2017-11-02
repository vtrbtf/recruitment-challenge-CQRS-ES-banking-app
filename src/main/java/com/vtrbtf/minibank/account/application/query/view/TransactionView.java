package com.vtrbtf.minibank.account.application.query.view;

import com.vtrbtf.minibank.account.event.AccountTransactionEvent;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class TransactionView {
    String name;
    BigDecimal value;

    public TransactionView(AccountTransactionEvent transaction) {
      name = transaction.getName();
      value = transaction.getValue();
    }
}
