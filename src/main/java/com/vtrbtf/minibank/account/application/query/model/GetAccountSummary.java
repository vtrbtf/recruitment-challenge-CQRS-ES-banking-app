package com.vtrbtf.minibank.account.application.query.model;

import com.vtrbtf.minibank.account.aggregate.Account;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class GetAccountSummary {
    String name;
    String type;
    BigDecimal balance;
    TransactionHistory transactions;
}
