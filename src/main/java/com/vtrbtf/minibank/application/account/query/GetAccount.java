package com.vtrbtf.minibank.application.account.query;

import com.vtrbtf.minibank.core.aggregate.account.Account;
import lombok.Value;
import lombok.experimental.PackagePrivate;

@Value
public class GetAccount {
    String name;
    public GetAccount(Account account) {
        name = account.getName();
    }
}
