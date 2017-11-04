package com.vtrbtf.minibank.application.command.model.account;

import com.vtrbtf.minibank.application.command.model.Command;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class OpenAccount implements Command {
    @TargetAggregateIdentifier
    String id;
    String clientId;
    String type;
}
