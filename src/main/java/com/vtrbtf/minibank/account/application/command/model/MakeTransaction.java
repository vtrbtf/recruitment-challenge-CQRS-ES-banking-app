package com.vtrbtf.minibank.account.application.command.model;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.math.BigDecimal;

@Value @NonFinal
public class MakeTransaction {
    String description;
    BigDecimal value;
}
