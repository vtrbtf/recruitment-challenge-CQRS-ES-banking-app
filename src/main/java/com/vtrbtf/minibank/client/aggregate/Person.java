package com.vtrbtf.minibank.client.aggregate;

import java.util.List;

public class Person extends Client {
    private String CPF;

    public Person(String id, List<String> accounts, String CPF) {
        super(id, accounts);
        this.CPF = CPF;
    }
}
