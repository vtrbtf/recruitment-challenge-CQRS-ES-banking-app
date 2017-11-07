package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.repository.view.ClientView;
import com.vtrbtf.minibank.application.query.client.repository.view.CompanyView;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetCompanyClient extends GetClient {
    private String CNPJ;

    public GetCompanyClient(ClientView clientView, CompanyView view) {
        super(clientView.getClientId(), clientView.getAccounts());
        CNPJ = view.getCNPJ();
    }
}
