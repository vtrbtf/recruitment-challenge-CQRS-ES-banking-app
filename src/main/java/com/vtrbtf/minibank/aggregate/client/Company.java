package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.application.command.client.EnrollCompany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Company implements Holder {
    String CNPJ;

    public Company(EnrollCompany command) {
        CNPJ = command.getCNPJ();
    }
}
