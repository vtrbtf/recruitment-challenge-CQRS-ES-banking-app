package com.vtrbtf.minibank.account.application.command.model;

import lombok.Value;
import lombok.experimental.NonFinal;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Value @NonFinal
public abstract class MakeTransaction implements Command {
    @TargetAggregateIdentifier
    String id;

    String description;
    BigDecimal value;
}
