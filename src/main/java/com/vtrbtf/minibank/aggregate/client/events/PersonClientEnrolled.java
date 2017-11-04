package com.vtrbtf.minibank.aggregate.client.events;

import com.vtrbtf.minibank.aggregate.client.Person;
import com.vtrbtf.minibank.application.command.model.client.EnrollPerson;

public class PersonClientEnrolled extends ClientEnrolled<Person> {
    public PersonClientEnrolled(EnrollPerson command) {
        super(command.getId(), new Person(command));
    }
}
