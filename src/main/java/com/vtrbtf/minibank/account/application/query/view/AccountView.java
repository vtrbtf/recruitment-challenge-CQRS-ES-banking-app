package com.vtrbtf.minibank.account.application.query.view;

import com.vtrbtf.minibank.account.event.AccountOpened;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class AccountView {
    String id;
    String type;
    List<TransactionView> transaction;

    public AccountView(AccountOpened account) {
        id = account.getId();
        type = account.getType().name();
        transaction = new ArrayList<>();
    }
}
