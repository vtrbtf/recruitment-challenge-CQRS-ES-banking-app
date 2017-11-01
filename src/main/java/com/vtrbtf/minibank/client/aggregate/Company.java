package com.vtrbtf.minibank.client.aggregate;

import lombok.Value;

import java.util.List;


public class Company extends Client {
    private final String CNPJ;

    public Company(String id, List<String> accounts, String CNPJ) {
        super(id, accounts);
        this.CNPJ = CNPJ;
    }
}
