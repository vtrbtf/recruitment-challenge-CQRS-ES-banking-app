package com.vtrbtf.minibank.account.application.command.model;

import com.vtrbtf.minibank.account.application.command.infrastructure.MakeDepositRequest;

import java.math.BigDecimal;

public class MakeDeposit extends MakeTransaction {
    public MakeDeposit(String id, String description, BigDecimal value) {
        super(id, description, value);
    }

    public MakeDeposit(String id, MakeDepositRequest request) {
        this(id, request.getDescription(), request.getValue());
    }
}
