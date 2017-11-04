package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.application.command.model.client.EnrollPerson;
import lombok.Value;

@Value
public class Person implements Holder {
    String CPF;
    public Person(EnrollPerson command) {
        CPF = command.getCPF();
    }
}
