package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.account.repository.view.AccountView;
import com.vtrbtf.minibank.application.query.client.http.QueryHttpHandler;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Value
@EqualsAndHashCode(callSuper = false)
public class GetAccountSummary extends ResourceSupport {
    String type;
    BigDecimal balance;

    public GetAccountSummary(String clientId, AccountView accountView) {
        add(linkTo(methodOn(QueryHttpHandler.class).accountSummary(clientId, accountView.getId())).withSelfRel());
        add(linkTo(methodOn(QueryHttpHandler.class).getClient(clientId)).withRel("client"));

        type = accountView.getType();
        balance = accountView.getBalance();
    }
}
