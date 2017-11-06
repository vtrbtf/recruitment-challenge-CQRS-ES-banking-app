package com.vtrbtf.minibank.application.query.client.repository.view;

import com.vtrbtf.minibank.aggregate.client.Company;
import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.client.http.payload.GetCompanyClient;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data @EqualsAndHashCode(callSuper = false)
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
