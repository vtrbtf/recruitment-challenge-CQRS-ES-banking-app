package com.vtrbtf.minibank.application.query.model.client.repository.view;

import com.vtrbtf.minibank.aggregate.client.Company;
import com.vtrbtf.minibank.application.query.model.client.http.payload.GetClient;

public class CompanyView extends ClientView {
    public CompanyView(Company type) {
        super();
    }

    @Override
    public GetClient toPayload() {
        return null;
    }
}
