package com.vtrbtf.minibank.application.query.client.message;

import com.vtrbtf.minibank.aggregate.client.account.events.AccountOpened;
import com.vtrbtf.minibank.aggregate.client.events.CompanyClientEnrolled;
import com.vtrbtf.minibank.aggregate.client.events.PersonClientEnrolled;
import com.vtrbtf.minibank.application.query.client.repository.ClientRepository;
import com.vtrbtf.minibank.application.query.client.repository.view.ClientView;
import com.vtrbtf.minibank.application.query.client.repository.view.CompanyView;
import com.vtrbtf.minibank.application.query.client.repository.view.PersonView;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static java.text.MessageFormat.format;

@Component
@Value
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ClientHandler {
    ClientRepository repository;

    @EventHandler
    public void on(PersonClientEnrolled event) {
        System.out.println(event);
        repository.save(new ClientView(event, new PersonView(event)));
    }

    @EventHandler
    public void on(CompanyClientEnrolled event) {
        repository.save(new ClientView(event, new CompanyView(event)));
    }

    @EventHandler
    public void on(AccountOpened event) {
        System.out.println(event.toString());
        ClientView clientView = repository.get(event.getClientId());
        if (clientView.getAccounts() == null ) clientView.setAccounts(new ArrayList<>());
        clientView.getAccounts().add(event.getAccountId());
        System.out.println(clientView.toString());
        repository.save(clientView);
    }
}
