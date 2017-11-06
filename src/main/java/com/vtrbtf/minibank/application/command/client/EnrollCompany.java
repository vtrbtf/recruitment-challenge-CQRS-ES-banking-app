package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.client.http.payload.EnrollCompanyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value @EqualsAndHashCode(callSuper = false)
public class EnrollCompany extends EnrollClient {
    String CNPJ;

    public EnrollCompany(String clientId, EnrollCompanyRequest request) {
        super(clientId, request.getName());
        this.CNPJ = request.getCNPJ();
    }
}
