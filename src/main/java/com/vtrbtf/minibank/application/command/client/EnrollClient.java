package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.Command;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
@NonFinal
public abstract class EnrollClient implements Command {
    @TargetAggregateIdentifier
    String clientId;
    String name;
}
