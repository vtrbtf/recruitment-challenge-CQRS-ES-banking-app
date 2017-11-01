package com.vtrbtf.minibank.account.application.command.model;

import lombok.Value;

import java.math.BigDecimal;

public class MakeDeposit extends MakeTransaction {

    public MakeDeposit(String description, BigDecimal value) {
        super(description, value);
    }
}
