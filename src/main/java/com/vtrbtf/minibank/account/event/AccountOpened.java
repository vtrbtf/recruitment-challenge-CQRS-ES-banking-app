package com.vtrbtf.minibank.account.event;

import com.vtrbtf.minibank.account.aggregate.AccountType;
import lombok.Value;

@Value
public class AccountOpened {
    String id;
    AccountType type;
}
