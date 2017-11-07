package com.vtrbtf.minibank.application.query.client.repository.view;

import com.vtrbtf.minibank.aggregate.client.events.PersonClientEnrolled;
import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.client.http.payload.GetPersonClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import java.util.ArrayList;

@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@BsonDiscriminator
public class PersonView implements HolderView {
    private String CPF;

    public PersonView(PersonClientEnrolled person) {
        CPF = person.getHolder().getCPF();
    }

    @Override
    public GetClient toPayload(ClientView view) {
        return new GetPersonClient(view, this);
    }
}
