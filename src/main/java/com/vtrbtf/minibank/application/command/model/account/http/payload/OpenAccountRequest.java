package com.vtrbtf.minibank.application.command.model.account.http.payload;

import com.vtrbtf.minibank.application.command.model.CommandConverter;
import com.vtrbtf.minibank.application.command.model.account.OpenAccount;
import lombok.Data;

@Data
public class OpenAccountRequest implements CommandConverter<OpenAccount> {
    private final String type;
    private String clientId;

    public OpenAccountRequest withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    @Override
    public OpenAccount toCommand(String accountId) {
        return new OpenAccount(clientId, accountId, type);
    }
}
