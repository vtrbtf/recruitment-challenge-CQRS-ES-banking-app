package com.vtrbtf.minibank.application.command.client.http.payload;

import com.vtrbtf.minibank.application.command.client.MakeDeposit;

public class MakeDepositRequest extends MakeTransactionRequest {
    @Override
    public MakeDeposit toCommand(String id) {
        return new MakeDeposit(id, this);
    }
}
