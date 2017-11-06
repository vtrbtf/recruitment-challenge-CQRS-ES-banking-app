package com.vtrbtf.minibank.application.query.model.client.repository.view;

import com.vtrbtf.minibank.aggregate.client.Person;
import com.vtrbtf.minibank.application.query.model.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.model.client.http.payload.GetPersonClient;
import lombok.Data;

@Data
public class PersonView extends ClientView {
    private String CPF;

    public PersonView(Person person) {
        CPF = person.getCPF();
    }

    @Override
    public GetClient toPayload() {
        return new GetPersonClient(this);
    }
}
