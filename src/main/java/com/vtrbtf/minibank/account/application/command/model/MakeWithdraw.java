package com.vtrbtf.minibank.account.application.command.model;

import com.vtrbtf.minibank.account.application.command.http.payload.MakeWithdrawRequest;

import java.math.BigDecimal;

public class MakeWithdraw extends MakeTransaction {
    public MakeWithdraw(String id, String description, BigDecimal value) {
        super(id, description, value);
    }

    public MakeWithdraw(String id, MakeWithdrawRequest request) {
        this(id, request.getDescription(), request.getValue());
    }
}
