package com.vtrbtf.minibank.account.aggregate;

import com.vtrbtf.minibank.account.aggregate.transaction.Transaction;
import com.vtrbtf.minibank.account.application.command.model.OpenAccount;
import com.vtrbtf.minibank.account.application.event.AccountOpened;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.Collections;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;


@AggregateRoot
@FieldDefaults(level = PRIVATE)
public class Account {

    @AggregateIdentifier
    String id;
    AccountType type;
    List<Transaction> transactions;

    private Account() { }

    @CommandHandler
    public Account(OpenAccount command){
        apply(new AccountOpened(command.getId(), AccountType.valueOf(command.getType())));
    }

    @EventSourcingHandler
    public void on(AccountOpened event) {
        id = event.getId();
        type = event.getType();
        transactions = Collections.emptyList();
    }
}
