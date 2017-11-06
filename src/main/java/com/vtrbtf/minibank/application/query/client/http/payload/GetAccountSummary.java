package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.account.repository.view.AccountView;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

@Value @EqualsAndHashCode(callSuper = false)
public class GetAccountSummary extends ResourceSupport {
    String type;
    BigDecimal balance;

    public GetAccountSummary(AccountView accountView) {
        type = accountView.getType();
        balance = accountView.getBalance();
    }
}
