package com.vtrbtf.minibank.application.command.client.http.payload;

import com.vtrbtf.minibank.application.command.client.EnrollClient;
import com.vtrbtf.minibank.application.command.client.EnrollCompany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Data @EqualsAndHashCode(callSuper = false)
public class EnrollCompanyRequest extends EnrollClientRequest {
    String CNPJ;

    @Override
    public EnrollClient toCommand(String clientId) {
        return new EnrollCompany(clientId, this);
    }
}
