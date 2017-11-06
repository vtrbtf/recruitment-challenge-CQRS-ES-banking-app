package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.Command;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Value
@NonFinal
public abstract class MakeTransaction implements Command {
    @TargetAggregateIdentifier
    String clientId;
    String accountId;
    String description;
    BigDecimal value;
}
