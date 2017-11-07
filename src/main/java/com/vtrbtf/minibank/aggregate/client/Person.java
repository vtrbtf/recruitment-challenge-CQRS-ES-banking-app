package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.application.command.client.EnrollPersonClient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person implements Holder {
    String CPF;

    public Person(EnrollPersonClient command) {
        CPF = command.getCPF();
    }
}
