package com.vtrbtf.minibank.application.query.model.client.http.payload;

import com.vtrbtf.minibank.application.query.model.client.repository.view.CompanyView;
import lombok.Data;

@Data
public class GetCompanyClient extends GetClient {
    private String CNPJ;

    public GetCompanyClient(CompanyView view) {
        CNPJ = view.getCNPJ();
    }
}
