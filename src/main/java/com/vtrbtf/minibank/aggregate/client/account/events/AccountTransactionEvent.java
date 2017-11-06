package com.vtrbtf.minibank.aggregate.client.account.events;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.math.BigDecimal;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AccountTransactionEvent {
    String clientId;
    String accountId;
    String name;
    BigDecimal value;
    BigDecimal balance;
}
