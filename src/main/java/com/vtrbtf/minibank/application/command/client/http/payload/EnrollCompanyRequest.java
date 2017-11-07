package com.vtrbtf.minibank.application.command.client.http.payload;

import com.vtrbtf.minibank.application.command.client.EnrollClient;
import com.vtrbtf.minibank.application.command.client.EnrollCompanyClient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnrollCompanyRequest extends EnrollClientRequest {
    String CNPJ;

    @Override
    public EnrollClient toCommand(String clientId) {
        return new EnrollCompanyClient(clientId, this);
    }
}
