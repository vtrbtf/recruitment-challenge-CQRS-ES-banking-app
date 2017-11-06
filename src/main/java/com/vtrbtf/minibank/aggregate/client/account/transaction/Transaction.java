package com.vtrbtf.minibank.aggregate.client.account.transaction;

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
}
