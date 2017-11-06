package com.vtrbtf.minibank.application.command.client.http.payload;

import com.vtrbtf.minibank.application.command.client.EnrollClient;
import com.vtrbtf.minibank.application.command.client.EnrollPerson;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = false)
public class EnrollPersonRequest extends EnrollClientRequest {
    String CPF;

    @Override
    public EnrollClient toCommand(String clientId) {
        return new EnrollPerson(clientId, this);
    }
}
