package com.vtrbtf.minibank.application.command.model.account;

import com.vtrbtf.minibank.application.command.model.account.http.payload.MakeDepositRequest;

public class MakeDeposit extends MakeTransaction {
    public MakeDeposit(String accountId, MakeDepositRequest request) {
        super(request.getClientId(), accountId, request.getDescription(), request.getValue());
    }
}
