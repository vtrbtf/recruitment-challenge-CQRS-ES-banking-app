package com.vtrbtf.minibank.application.command.model.account.http.payload;

import com.vtrbtf.minibank.application.command.model.account.MakeWithdraw;

public class MakeWithdrawRequest extends MakeTransactionRequest {
    @Override
    public MakeWithdraw toCommand(String id) {
        return new MakeWithdraw(id, this);
    }
}
