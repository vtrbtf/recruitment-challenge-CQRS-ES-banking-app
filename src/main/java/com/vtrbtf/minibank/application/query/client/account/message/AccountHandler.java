package com.vtrbtf.minibank.application.query.client.account.message;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountOpened;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountTransactionEvent;
import com.vtrbtf.minibank.application.query.client.account.repository.AccountRepository;
import com.vtrbtf.minibank.application.query.infrastructure.EmailGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.text.MessageFormat.format;

@Component
@lombok.Value
public class AccountHandler {
    AccountRepository repository;
    EmailGateway emailGateway;
    String CFOAddress;

    @Autowired
    public AccountHandler(AccountRepository repository, EmailGateway emailGateway,
                          @Value("${mailing.address.CFO}") String CFOAddress) {
        this.repository = repository;
        this.emailGateway = emailGateway;
        this.CFOAddress = CFOAddress;
    }

    @EventHandler
    public void on(AccountOpened event) {
        repository.save(event);
        emailGateway.send("New Account was just opened",
                format("The account #{0} was just opened", event.getAccountId()), CFOAddress);
    }

    @EventHandler
    public void on(AccountTransactionEvent transaction) {
        repository.pushTransaction(transaction, transaction.getBalance());
    }
}
