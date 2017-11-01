package com.vtrbtf.minibank.account.aggregate.transaction;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.math.BigDecimal;

@Value @NonFinal
public class Transaction {
    String name;
    BigDecimal value;
}
