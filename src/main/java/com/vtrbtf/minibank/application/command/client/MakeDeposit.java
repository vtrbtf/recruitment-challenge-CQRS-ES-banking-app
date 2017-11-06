package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.client.http.payload.MakeDepositRequest;

public class MakeDeposit extends MakeTransaction {
    public MakeDeposit(String accountId, MakeDepositRequest request) {
        super(request.getClientId(), accountId, request.getDescription(), request.getValue());
    }
}
