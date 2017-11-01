package com.vtrbtf.minibank.account.application.command;

import com.vtrbtf.minibank.account.application.command.infrastructure.MakeTransactionRequest;
import com.vtrbtf.minibank.account.application.command.infrastructure.OpenAccountRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.Future;

@RestController @RequestMapping("/account")
public class AccountCommandHttpHandler {
    @Autowired CommandGateway commander;

    @PostMapping
    public Future<?> openAccount(@RequestBody OpenAccountRequest account) {
        return commander.send(account.toCommand(UUID.randomUUID().toString()));
    }

    @PostMapping("/{accountId}/transaction")
    public Future<?> makeTransaction(@PathVariable String accountId, @RequestBody MakeTransactionRequest transaction) {
        return commander.send(transaction.toCommand(accountId));
    }

}
