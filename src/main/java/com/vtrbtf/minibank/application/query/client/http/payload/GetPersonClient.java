package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.repository.view.PersonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = false)
public class GetPersonClient extends GetClient {
    private String name;
    private String type;

    public GetPersonClient(PersonView view) {
        name = view.getCPF();
    }
}
