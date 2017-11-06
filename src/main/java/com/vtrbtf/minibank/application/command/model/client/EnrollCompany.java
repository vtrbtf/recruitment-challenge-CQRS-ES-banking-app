package com.vtrbtf.minibank.application.command.model.client;

import com.vtrbtf.minibank.application.command.model.client.http.payload.EnrollCompanyRequest;
import lombok.Data;

@Data
public class EnrollCompany extends EnrollClient {
    String CNPJ;

    public EnrollCompany(String clientId, EnrollCompanyRequest request) {
        super(clientId, request.getName());
        this.CNPJ = request.getCNPJ();
    }
}
