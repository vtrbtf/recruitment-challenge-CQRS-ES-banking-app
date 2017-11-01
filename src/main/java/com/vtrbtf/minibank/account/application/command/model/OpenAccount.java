package com.vtrbtf.minibank.account.application.command.model;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class OpenAccount {

    @TargetAggregateIdentifier
    String id;
    String type;
}
