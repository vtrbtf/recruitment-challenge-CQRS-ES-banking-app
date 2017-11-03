package com.vtrbtf.minibank.account.event;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

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
