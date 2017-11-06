package com.vtrbtf.minibank.aggregate.client.account.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountTransactionEvent {
    String clientId;
    String accountId;
    String name;
    BigDecimal value;
    BigDecimal balance;
}
