package com.vtrbtf.minibank.account.event;

import com.vtrbtf.minibank.account.aggregate.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOpened {
    String id;
    AccountType type;
}
