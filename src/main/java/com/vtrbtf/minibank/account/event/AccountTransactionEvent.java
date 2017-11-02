package com.vtrbtf.minibank.account.event;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.math.BigDecimal;

@Value @NonFinal
public class AccountTransactionEvent {
    String id;
    String name;
    BigDecimal value;
}
