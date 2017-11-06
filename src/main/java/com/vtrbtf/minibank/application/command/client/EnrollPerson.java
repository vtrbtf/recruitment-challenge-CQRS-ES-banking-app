package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.client.http.payload.EnrollPersonRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;


@Value @EqualsAndHashCode(callSuper = false)
public class EnrollPerson extends EnrollClient {
    private String CPF;

    public EnrollPerson(String clientId, EnrollPersonRequest request) {
        super(clientId, request.getName());
        this.CPF = request.getCPF();
    }
}
