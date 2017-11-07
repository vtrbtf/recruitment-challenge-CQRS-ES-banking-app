package com.vtrbtf.minibank.application.command.client.http.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtrbtf.minibank.application.command.client.EnrollClient;
import com.vtrbtf.minibank.application.command.client.EnrollPersonClient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnrollPersonRequest extends EnrollClientRequest {

    @JsonProperty("CPF")
    private String CPF;

    @Override
    public EnrollClient toCommand(String clientId) {
        return new EnrollPersonClient(clientId, this);
    }
}
