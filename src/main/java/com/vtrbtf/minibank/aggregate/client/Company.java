package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.application.command.model.client.EnrollCompany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
public class Company implements Holder {
    String CNPJ;

    public Company(EnrollCompany command) {
        CNPJ = command.getCNPJ();
    }
}
