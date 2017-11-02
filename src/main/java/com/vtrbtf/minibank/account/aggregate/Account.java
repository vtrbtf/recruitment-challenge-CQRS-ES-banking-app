package com.vtrbtf.minibank.account.aggregate;

import com.vtrbtf.minibank.account.aggregate.transaction.Deposit;
import com.vtrbtf.minibank.account.aggregate.transaction.Transaction;
import com.vtrbtf.minibank.account.aggregate.transaction.Withdraw;
import com.vtrbtf.minibank.account.application.command.model.MakeDeposit;
import com.vtrbtf.minibank.account.application.command.model.MakeWithdraw;
import com.vtrbtf.minibank.account.application.command.model.OpenAccount;
import com.vtrbtf.minibank.account.event.AccountDeposited;
import com.vtrbtf.minibank.account.event.AccountOpened;
import com.vtrbtf.minibank.account.event.AccountWithdrew;
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
        transactions = new ArrayList<>();
    }

    @CommandHandler
    public void on(MakeWithdraw command){
        apply(new AccountWithdrew(command.getId(), command.getDescription(), command.getValue()));
    }

    @EventSourcingHandler
    public void on(AccountWithdrew event) {
        transactions.add(new Withdraw(event));
    }

    @CommandHandler
    public void on(MakeDeposit command){
        apply(new AccountDeposited(command.getId(), command.getDescription(), command.getValue()));
    }

    @EventSourcingHandler
    public void on(AccountDeposited event) {
        transactions.add(new Deposit(event));
    }
}
