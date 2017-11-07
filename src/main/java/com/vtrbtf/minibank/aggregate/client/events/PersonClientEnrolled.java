package com.vtrbtf.minibank.aggregate.client.events;

import com.vtrbtf.minibank.aggregate.client.Person;
import com.vtrbtf.minibank.application.command.client.EnrollPersonClient;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PersonClientEnrolled extends ClientEnrolled<Person> {

    public PersonClientEnrolled(EnrollPersonClient command) {
        super(command.getClientId(), new Person(command));
    }
}
