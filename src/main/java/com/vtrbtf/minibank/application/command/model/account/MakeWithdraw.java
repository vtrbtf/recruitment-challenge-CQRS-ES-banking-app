package com.vtrbtf.minibank.application.command.model.account;

import com.vtrbtf.minibank.application.command.model.account.http.payload.MakeWithdrawRequest;

public class MakeWithdraw extends MakeTransaction {
    public MakeWithdraw(String id, MakeWithdrawRequest request) {
        super(id, request.getClientId(), request.getDescription(), request.getValue());
    }
}
