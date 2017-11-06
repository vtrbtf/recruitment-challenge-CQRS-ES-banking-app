package com.vtrbtf.minibank.application.query.client.repository.view;

import com.vtrbtf.minibank.aggregate.client.Person;
import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.client.http.payload.GetPersonClient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = false)
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
