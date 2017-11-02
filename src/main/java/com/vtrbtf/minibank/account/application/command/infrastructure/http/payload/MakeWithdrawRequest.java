package com.vtrbtf.minibank.account.application.command.infrastructure.http.payload;

import com.vtrbtf.minibank.account.application.command.model.MakeWithdraw;

public class MakeWithdrawRequest extends MakeTransactionRequest {
    @Override
    public MakeWithdraw toCommand(String id) {
        return new MakeWithdraw(id, this);
    }
}
