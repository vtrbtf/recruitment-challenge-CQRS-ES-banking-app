package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.Command;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class OpenAccount implements Command {
    @TargetAggregateIdentifier
    String clientId;
    String accountId;
    String type;
}
