package com.vtrbtf.minibank.application.query.model.client.http.payload;

import lombok.Data;

@Data
public class GetPersonClient extends GetClient {
    private String name;
    private String type;
}
