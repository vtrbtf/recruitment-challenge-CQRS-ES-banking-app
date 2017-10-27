package com.vtrbtf.minibank.core.domain.transaction;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Transaction {
    String id;
    String name;
    BigDecimal value;
}
