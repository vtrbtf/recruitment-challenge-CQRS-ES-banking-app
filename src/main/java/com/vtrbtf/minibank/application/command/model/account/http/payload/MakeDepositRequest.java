package com.vtrbtf.minibank.application.command.model.account.http.payload;

import com.vtrbtf.minibank.application.command.model.account.MakeDeposit;

public class MakeDepositRequest extends MakeTransactionRequest {
    @Override
    public MakeDeposit toCommand(String id) {
        return new MakeDeposit(id,this);
    }
}
