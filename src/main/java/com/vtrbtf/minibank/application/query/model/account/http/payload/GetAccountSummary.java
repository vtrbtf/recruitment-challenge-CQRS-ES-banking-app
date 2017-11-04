package com.vtrbtf.minibank.application.query.model.account.http.payload;

import com.vtrbtf.minibank.application.query.model.account.repository.view.AccountView;
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
