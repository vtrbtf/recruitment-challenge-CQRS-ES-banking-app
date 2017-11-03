package com.vtrbtf.minibank.account.application.command.http.payload;

import com.vtrbtf.minibank.account.application.command.model.MakeDeposit;

public class MakeDepositRequest extends MakeTransactionRequest {
    @Override
    public MakeDeposit toCommand(String id) {
        return new MakeDeposit(id,this);
    }
}
