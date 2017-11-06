package com.vtrbtf.minibank.application.query.model.client.message;

import com.vtrbtf.minibank.aggregate.client.events.CompanyClientEnrolled;
import com.vtrbtf.minibank.aggregate.client.events.PersonClientEnrolled;
import com.vtrbtf.minibank.application.query.model.client.repository.ClientRepository;
import com.vtrbtf.minibank.application.query.model.client.repository.view.CompanyView;
import com.vtrbtf.minibank.application.query.model.client.repository.view.PersonView;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientHandler {
    @Autowired
    ClientRepository repository;

    @EventHandler
    public void on(PersonClientEnrolled event) {
        repository.save(new PersonView(event.getHolder()));
    }

    @EventHandler
    public void on(CompanyClientEnrolled event) {
        repository.save(new CompanyView(event.getHolder()));
    }
}
