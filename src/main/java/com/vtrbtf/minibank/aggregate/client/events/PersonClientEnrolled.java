package com.vtrbtf.minibank.aggregate.client.events;

import com.vtrbtf.minibank.aggregate.client.Person;
import com.vtrbtf.minibank.application.command.client.EnrollPerson;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PersonClientEnrolled extends ClientEnrolled<Person> {

    public PersonClientEnrolled(EnrollPerson command) {
        super(command.getClientId(), new Person(command));
    }
}
