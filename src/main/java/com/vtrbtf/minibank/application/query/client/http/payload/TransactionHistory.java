package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.account.repository.view.AccountView;
import com.vtrbtf.minibank.application.query.client.account.repository.view.TransactionView;
import com.vtrbtf.minibank.application.query.client.http.QueryHttpHandler;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Value
@EqualsAndHashCode(callSuper = false)
public class TransactionHistory extends ResourceSupport {
    List<TransactionEntry> history;

    public TransactionHistory(String clientId, AccountView accountView) {
        add(linkTo(methodOn(QueryHttpHandler.class).accountSummary(clientId, accountView.getId())).withRel("account"));
        add(linkTo(methodOn(QueryHttpHandler.class).getClient(clientId)).withRel("client"));

        history = accountView.getTransactions().stream().map(TransactionEntry::new).collect(Collectors.toList());
    }

    @Value
    class TransactionEntry {
        String name;
        BigDecimal value;

        TransactionEntry(TransactionView view) {
            name = view.getName();
            value = view.getValue();
        }
    }
}
