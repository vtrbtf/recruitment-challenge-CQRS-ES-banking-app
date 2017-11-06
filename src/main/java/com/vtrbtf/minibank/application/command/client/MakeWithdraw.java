package com.vtrbtf.minibank.application.command.client;

import com.vtrbtf.minibank.application.command.client.http.payload.MakeWithdrawRequest;

public class MakeWithdraw extends MakeTransaction {
    public MakeWithdraw(String accountId, MakeWithdrawRequest request) {
        super(request.getClientId(), accountId, request.getDescription(), request.getValue());
    }
}
