package com.vtrbtf.minibank.account.application.query.http.payload;

import com.vtrbtf.minibank.account.application.query.repository.view.AccountView;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class GetAccountSummary {
    String type;
    BigDecimal balance;

    public GetAccountSummary(AccountView accountView) {
        type = accountView.getType();
        balance = accountView.getBalance();
    }
}
