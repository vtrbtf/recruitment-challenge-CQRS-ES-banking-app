package com.vtrbtf.minibank.account.application.query.message;

import com.vtrbtf.minibank.account.application.query.AccountRepository;
import com.vtrbtf.minibank.account.event.AccountOpened;
import com.vtrbtf.minibank.account.event.AccountTransactionEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountHandler {

    @Autowired
    AccountRepository repository;

    @EventHandler
    public void on(AccountOpened event) {
        repository.save(event);
    }

    @EventHandler
    public void on(AccountTransactionEvent event) {
        repository.pushTransaction(event);
    }
}
