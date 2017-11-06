package com.vtrbtf.minibank.application.query.model.client.http.payload;

import com.vtrbtf.minibank.application.query.model.client.repository.view.PersonView;
import lombok.Data;

@Data
public class GetPersonClient extends GetClient {
    private String name;
    private String type;

    public GetPersonClient(PersonView view) {
        name = view.getCPF();
    }
}
