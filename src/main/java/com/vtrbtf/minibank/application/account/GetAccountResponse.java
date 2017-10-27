package com.vtrbtf.minibank.application.account;

import com.vtrbtf.minibank.core.domain.account.Account;
import lombok.Value;
import lombok.experimental.PackagePrivate;

@Value @PackagePrivate
class GetAccountResponse {
    String name;

    GetAccountResponse(Account account) {
        name = account.getName();
    }
}
