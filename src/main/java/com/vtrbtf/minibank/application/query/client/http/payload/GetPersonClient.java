package com.vtrbtf.minibank.application.query.client.http.payload;

import com.vtrbtf.minibank.application.query.client.repository.view.ClientView;
import com.vtrbtf.minibank.application.query.client.repository.view.PersonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetPersonClient extends GetClient {
    private String name;
    private String type;

    public GetPersonClient(ClientView clientView, PersonView view) {
        super(clientView.getClientId(), clientView.getAccounts());
        name = view.getCPF();
    }
}
