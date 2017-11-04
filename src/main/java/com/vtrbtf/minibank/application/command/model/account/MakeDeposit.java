package com.vtrbtf.minibank.application.command.model.account;

import com.vtrbtf.minibank.application.command.model.account.http.payload.MakeDepositRequest;

public class MakeDeposit extends MakeTransaction {
    public MakeDeposit(String id, MakeDepositRequest request) {
        super(id, request.getClientId(), request.getDescription(), request.getValue());
    }
}
