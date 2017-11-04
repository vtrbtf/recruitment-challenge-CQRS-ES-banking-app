package com.vtrbtf.minibank.application.command.model.client.http.payload;

import com.vtrbtf.minibank.application.command.model.client.EnrollClient;
import com.vtrbtf.minibank.application.command.model.client.EnrollCompany;
import com.vtrbtf.minibank.application.command.model.client.EnrollPerson;
import lombok.Data;

@Data
public class EnrollCompanyRequest extends EnrollClientRequest {
    String CNPJ;
    @Override
    public EnrollClient toCommand(String id) {
        return new EnrollCompany(id, this);
    }
}
