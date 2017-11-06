package com.vtrbtf.minibank.application.command.model.client.http.payload;

import com.vtrbtf.minibank.application.command.model.client.EnrollClient;
import com.vtrbtf.minibank.application.command.model.client.EnrollPerson;
import lombok.Data;

@Data
public class EnrollPersonRequest extends EnrollClientRequest {
    String CPF;
    @Override
    public EnrollClient toCommand(String clientId) {
        return new EnrollPerson(clientId, this);
    }
}
