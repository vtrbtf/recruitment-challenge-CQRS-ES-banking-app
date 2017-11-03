package com.vtrbtf.minibank.account.application.query.message;

import com.vtrbtf.minibank.account.application.query.repository.AccountRepository;
import com.vtrbtf.minibank.account.event.AccountOpened;
import com.vtrbtf.minibank.account.event.AccountTransactionEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.text.MessageFormat.*;

@Component
public class AccountHandler {
    @Autowired
    AccountRepository repository;

    @Autowired
    EmailGateway emailGateway;

    @Value("${mailing.address.CFO}")
    String CFOAddress;


    @EventHandler
    public void on(AccountOpened event) {
        repository.save(event);
        emailGateway.send("New Account was just opened", format("The account #{0} was just opened", event.getId()), CFOAddress);
    }

    @EventHandler
    public void on(AccountTransactionEvent transaction) {
        repository.pushTransaction(transaction, transaction.getBalance());
    }
}
