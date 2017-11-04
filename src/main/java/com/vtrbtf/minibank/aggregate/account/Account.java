package com.vtrbtf.minibank.aggregate.account;

import com.vtrbtf.minibank.aggregate.account.transaction.Deposit;
import com.vtrbtf.minibank.aggregate.account.transaction.Transaction;
import com.vtrbtf.minibank.aggregate.account.transaction.Withdraw;
import com.vtrbtf.minibank.application.command.model.account.MakeDeposit;
import com.vtrbtf.minibank.application.command.model.account.MakeTransaction;
import com.vtrbtf.minibank.application.command.model.account.MakeWithdraw;
import com.vtrbtf.minibank.application.command.model.account.OpenAccount;
import com.vtrbtf.minibank.aggregate.account.events.AccountDeposited;
import com.vtrbtf.minibank.aggregate.account.events.AccountOpened;
import com.vtrbtf.minibank.aggregate.account.events.AccountWithdrew;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;


@AggregateRoot
@FieldDefaults(level = PRIVATE)
public class Account {
    @AggregateIdentifier
    String id;
    String clientId;
    AccountType type;
    List<Transaction> transactions;

    private Account() { }

    @CommandHandler
    public Account(OpenAccount command){
        apply(new AccountOpened(command.getId(), command.getClientId(),AccountType.valueOf(command.getType())));
    }

    @EventSourcingHandler
    public void on(AccountOpened event) {
        id = event.getId();
        clientId = event.getClientId();
        type = event.getType();
        transactions = new ArrayList<>();
    }

    @CommandHandler
    public void on(MakeWithdraw command){
        transactionsShouldTargetProperClientId(command);
        apply(new AccountWithdrew(command.getId(), command.getDescription(), command.getValue(), projectBalance(command.getValue())));
    }

    private void transactionsShouldTargetProperClientId(MakeTransaction command) {
        assert command.getClientId().equals(clientId);
    }

    @EventSourcingHandler
    public void on(AccountWithdrew event) {
        transactions.add(new Withdraw(event));
    }

    @CommandHandler
    public void on(MakeDeposit command){
        apply(new AccountDeposited(command.getId(), command.getDescription(), command.getValue(), projectBalance(command.getValue())));
    }

    @EventSourcingHandler
    public void on(AccountDeposited event) {
        transactions.add(new Deposit(event));
    }

    public BigDecimal currentBalance() {
        return BigDecimal.valueOf(transactions.stream().mapToDouble(t -> t.getValue().doubleValue()).sum());
    }

    private BigDecimal projectBalance(BigDecimal projectedTransactionValue) {
        return currentBalance().add(projectedTransactionValue);
    }
}
