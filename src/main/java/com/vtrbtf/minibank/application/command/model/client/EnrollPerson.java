package com.vtrbtf.minibank.application.command.model.client;

import com.vtrbtf.minibank.application.command.model.client.http.payload.EnrollPersonRequest;
import lombok.Data;


@Data
public class EnrollPerson extends EnrollClient {
    private String CPF;
    public EnrollPerson(String id, EnrollPersonRequest request) {
        super(id, request.getName());
        this.CPF = request.getCPF();
    }
}