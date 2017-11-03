package com.vtrbtf.minibank.account.application.command.http.payload;

import com.vtrbtf.minibank.account.application.command.model.CommandConverter;
import com.vtrbtf.minibank.account.application.command.model.OpenAccount;
import lombok.Value;

@Value
public class OpenAccountRequest implements CommandConverter<OpenAccount> {
    String type;
    @Override
    public OpenAccount toCommand(String id) {
        return new OpenAccount(id, type);
    }
}
