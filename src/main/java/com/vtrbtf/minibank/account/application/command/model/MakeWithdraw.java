package com.vtrbtf.minibank.account.application.command.model;

import lombok.Value;

import java.math.BigDecimal;

public class MakeWithdraw extends MakeTransaction {
    public MakeWithdraw(String description, BigDecimal value) {
        super(description, value);
    }
}
