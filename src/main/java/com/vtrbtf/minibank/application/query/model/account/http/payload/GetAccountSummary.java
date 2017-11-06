package com.vtrbtf.minibank.application.query.model.account.http.payload;

import com.vtrbtf.minibank.application.query.model.account.repository.view.AccountView;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

@Value
public class GetAccountSummary extends ResourceSupport {
    String type;
    BigDecimal balance;

    public GetAccountSummary(AccountView accountView) {
        type = accountView.getType();
        balance = accountView.getBalance();
    }
}
