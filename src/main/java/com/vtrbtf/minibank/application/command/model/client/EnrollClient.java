package com.vtrbtf.minibank.application.command.model.client;

import com.vtrbtf.minibank.application.command.model.Command;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
@NonFinal
public abstract class EnrollClient implements Command {
    @TargetAggregateIdentifier
    String id;
    String name;
}
