package com.vtrbtf.minibank.aggregate.client;

import com.vtrbtf.minibank.application.command.client.EnrollCompanyClient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Company implements Holder {
    String CNPJ;

    public Company(EnrollCompanyClient command) {
        CNPJ = command.getCNPJ();
    }
}
