package com.vtrbtf.minibank.account.application.query.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class GetAccountSummary {
    String name;
    String type;
    BigDecimal balance;
}
