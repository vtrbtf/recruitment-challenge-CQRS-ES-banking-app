package com.vtrbtf.minibank.aggregate.account.events;

import com.vtrbtf.minibank.aggregate.account.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOpened {
    String id;
    String clientId;
    AccountType type;
}
