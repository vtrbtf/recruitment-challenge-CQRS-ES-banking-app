package com.vtrbtf.minibank.application.account.command;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;

import java.math.BigDecimal;

@Value @NonFinal
public class MakeTransaction {
    String description;
    BigDecimal value;
}
