package com.vtrbtf.minibank.application.query.client.message;

import com.vtrbtf.minibank.aggregate.client.events.CompanyClientEnrolled;
import com.vtrbtf.minibank.aggregate.client.events.PersonClientEnrolled;
import com.vtrbtf.minibank.application.query.client.repository.ClientRepository;
import com.vtrbtf.minibank.application.query.client.repository.view.CompanyView;
import com.vtrbtf.minibank.application.query.client.repository.view.PersonView;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Value @RequiredArgsConstructor(onConstructor=@__({@Autowired}))
public class ClientHandler {
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
