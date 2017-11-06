package com.vtrbtf.minibank.aggregate.client.account.events;

import com.vtrbtf.minibank.aggregate.client.account.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOpened {
    String clientId;
    String accountId;
    AccountType type;
}
