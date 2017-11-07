package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.client.http.payload.EnrollCompanyRequest;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class EnrollCompanyClient extends EnrollClient {
    String CNPJ;

    public EnrollCompanyClient(String clientId, EnrollCompanyRequest request) {
        super(clientId, request.getName());
        this.CNPJ = request.getCNPJ();
    }
}
