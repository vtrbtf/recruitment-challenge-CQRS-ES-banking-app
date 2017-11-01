package com.vtrbtf.minibank.account.application.command.infrastructure;

import com.vtrbtf.minibank.account.application.command.model.OpenAccount;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class OpenAccountRequest implements CommandConverter<OpenAccount> {
    String type;
    @Override
    public OpenAccount toCommand(String id) {
        return new OpenAccount(id, type);
    }
}
