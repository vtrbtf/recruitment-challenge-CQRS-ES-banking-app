package com.vtrbtf.minibank.application.query.model.client.http.payload;

import lombok.Data;

@Data
public class GetCompanyClient extends GetClient {
    private String name;
    private String type;
}
