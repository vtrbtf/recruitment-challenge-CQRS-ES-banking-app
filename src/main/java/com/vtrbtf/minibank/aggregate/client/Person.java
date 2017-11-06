package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.application.command.model.client.EnrollPerson;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
public class Person implements Holder {
    String CPF;
    public Person(EnrollPerson command) {
        CPF = command.getCPF();
    }
}
