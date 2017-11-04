package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.application.command.model.client.EnrollCompany;
import lombok.Value;

@Value
public class Company implements Holder {
    String CNPJ;

    public Company(EnrollCompany command) {
        CNPJ = command.getCNPJ();
    }
}
