package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.aggregate.client.account.Account;
import com.vtrbtf.minibank.aggregate.client.account.AccountType;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountDeposited;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountOpened;
import com.vtrbtf.minibank.aggregate.client.account.events.AccountWithdrew;
import com.vtrbtf.minibank.aggregate.client.events.ClientEnrolled;
import com.vtrbtf.minibank.aggregate.client.events.CompanyClientEnrolled;
import com.vtrbtf.minibank.aggregate.client.events.PersonClientEnrolled;
import com.vtrbtf.minibank.application.command.client.*;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@AggregateRoot
@FieldDefaults(level = PRIVATE)
public class Client {
    @AggregateIdentifier
    String clientId;
    Holder holder;
    List<Account> accounts;

    private Client() { }

    @CommandHandler
    public Client(EnrollCompany command) {
        apply(new CompanyClientEnrolled(command));
    }

    @CommandHandler
    public Client(EnrollPerson command) {
        apply(new PersonClientEnrolled(command));
    }

    @EventSourcingHandler
    public void on(ClientEnrolled event) {
        clientId = event.getClientId();
        holder = event.getHolder();
        accounts = new ArrayList<>();
    }

    @EventSourcingHandler
    public void on(AccountOpened event) {
        accounts.add(Account.open(event));
    }

    @EventSourcingHandler
    public void on(AccountWithdrew event) {
        withAccount(event.getAccountId()).withdraw(event);
    }

    @EventSourcingHandler
    public void on(AccountDeposited event) {
        withAccount(event.getAccountId()).deposit(event);
    }

    @CommandHandler
    public void on(OpenAccount command) {
        apply(new AccountOpened(command.getClientId(), command.getAccountId(), AccountType.valueOf(command.getType())));
    }

    @CommandHandler
    public void on(MakeWithdraw command) {
        apply(new AccountWithdrew(command.getClientId(), command.getAccountId(), command.getDescription(), command.getValue(), withAccount(command.getAccountId()).projectBalance(command.getValue())));
    }

    @CommandHandler
    public void on(MakeDeposit command) {
        apply(new AccountDeposited(command.getClientId(), command.getAccountId(), command.getDescription(), command.getValue(), withAccount(command.getAccountId()).projectBalance(command.getValue())));
    }

    private Account withAccount(String accountId) {
        return accounts.stream().filter(account -> account.getAccountId().equals(accountId)).findFirst().get();
    }
}
