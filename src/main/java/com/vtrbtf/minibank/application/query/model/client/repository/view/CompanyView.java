package com.vtrbtf.minibank.application.query.model.client.repository.view;

import com.vtrbtf.minibank.aggregate.client.Company;
import com.vtrbtf.minibank.application.query.model.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.model.client.http.payload.GetCompanyClient;
import lombok.Data;


@Data
public class CompanyView extends ClientView {
    private String CNPJ;

    public CompanyView(Company company) {
        CNPJ = company.getCNPJ();
    }

    @Override
    public GetClient toPayload() {
        return new GetCompanyClient(this);
    }
}
