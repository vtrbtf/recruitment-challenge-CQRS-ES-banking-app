package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.repository.view.CompanyView;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = false)
public class GetCompanyClient extends GetClient {
    private String CNPJ;

    public GetCompanyClient(CompanyView view) {
        CNPJ = view.getCNPJ();
    }
}
