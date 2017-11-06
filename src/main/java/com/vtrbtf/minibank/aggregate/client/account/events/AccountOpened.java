package com.vtrbtf.minibank.aggregate.client.account.events;

import com.vtrbtf.minibank.aggregate.client.account.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountOpened {
    String clientId;
    String accountId;
    AccountType type;
}
