package com.vtrbtf.minibank.aggregate.account.events;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class AccountTransactionEvent {
    String id;
    String name;
    BigDecimal value;
    BigDecimal balance;
}
