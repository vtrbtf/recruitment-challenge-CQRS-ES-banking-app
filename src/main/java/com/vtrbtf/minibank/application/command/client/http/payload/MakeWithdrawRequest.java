package com.vtrbtf.minibank.application.command.client.http.payload;

import com.vtrbtf.minibank.application.command.client.MakeWithdraw;

public class MakeWithdrawRequest extends MakeTransactionRequest {
    @Override
    public MakeWithdraw toCommand(String accountId) {
        return new MakeWithdraw(accountId, this);
    }
}
