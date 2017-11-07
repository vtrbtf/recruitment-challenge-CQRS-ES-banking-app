package com.vtrbtf.minibank.application.command.client.http.payload;

import com.vtrbtf.minibank.application.command.CommandConverter;
import com.vtrbtf.minibank.application.command.client.OpenAccount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OpenAccountRequest implements CommandConverter<OpenAccount> {
    String type;
    String clientId;

    public OpenAccountRequest withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    @Override
    public OpenAccount toCommand(String accountId) {
        return new OpenAccount(clientId, accountId, type);
    }
}
