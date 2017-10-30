package com.vtrbtf.minibank.core.aggregate.account.transaction;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.math.BigDecimal;

@Value @NonFinal
public class Transaction {
    String name;
    BigDecimal value;
}
