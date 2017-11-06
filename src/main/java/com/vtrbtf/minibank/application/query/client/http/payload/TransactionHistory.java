package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.account.repository.view.AccountView;
import com.vtrbtf.minibank.application.query.client.account.repository.view.TransactionView;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value @EqualsAndHashCode(callSuper = false)
public class TransactionHistory extends ResourceSupport {
    List<TransactionEntry> history;

    public TransactionHistory(AccountView accountView) {
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
