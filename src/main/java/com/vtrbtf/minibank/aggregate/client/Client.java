package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.aggregate.client.events.ClientEnrolled;
import com.vtrbtf.minibank.aggregate.client.events.CompanyClientEnrolled;
import com.vtrbtf.minibank.aggregate.client.events.PersonClientEnrolled;
import com.vtrbtf.minibank.application.command.model.client.EnrollCompany;
import com.vtrbtf.minibank.application.command.model.client.EnrollPerson;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static lombok.AccessLevel.PRIVATE;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@AggregateRoot
@FieldDefaults(level = PRIVATE)
public class Client {
    @AggregateIdentifier
    String id;
    Holder holder;

    @CommandHandler
    public Client(EnrollCompany command){
        apply(new CompanyClientEnrolled(command));
    }

    @CommandHandler
    public Client(EnrollPerson command){
        apply(new PersonClientEnrolled(command));
    }

    @EventSourcingHandler
    public void on(ClientEnrolled event) {
        id = event.getId();
        holder = event.getType();
    }
}
