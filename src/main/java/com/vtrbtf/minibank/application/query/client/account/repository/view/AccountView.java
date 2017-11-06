package com.vtrbtf.minibank.application.query.client.account.repository.view;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountOpened;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountView {
    String id;
    String type;
    BigDecimal balance;
    List<TransactionView> transactions;

    public AccountView() {
    }

    public AccountView(AccountOpened account) {
        id = account.getAccountId();
        type = account.getType().name();
        balance = BigDecimal.ZERO;
        transactions = new ArrayList<>();
    }
}
