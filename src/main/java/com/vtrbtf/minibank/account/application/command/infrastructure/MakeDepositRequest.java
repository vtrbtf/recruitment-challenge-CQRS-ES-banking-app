package com.vtrbtf.minibank.account.application.command.infrastructure;

import com.vtrbtf.minibank.account.application.command.model.MakeDeposit;

public class MakeDepositRequest extends MakeTransactionRequest {
    @Override
    public MakeDeposit toCommand(String id) {
        return new MakeDeposit(id,this);
    }
}
