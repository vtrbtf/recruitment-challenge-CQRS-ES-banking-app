package com.vtrbtf.minibank.account.application.command.infrastructure.http;

import com.vtrbtf.minibank.account.application.command.infrastructure.http.payload.MakeTransactionRequest;
import com.vtrbtf.minibank.account.application.command.infrastructure.http.payload.OpenAccountRequest;
import com.vtrbtf.minibank.account.application.command.model.OpenAccount;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;
import java.util.concurrent.Future;

import static org.springframework.http.ResponseEntity.created;

@RestController @RequestMapping(AccountCommandHttpHandler.ACCOUNT_ENDPOINT)
public class AccountCommandHttpHandler {
    public static final String ACCOUNT_ENDPOINT = "/account";

    @Autowired CommandGateway commander;

    @PostMapping
    public Future openAccount(@RequestBody OpenAccountRequest account, UriComponentsBuilder uri) {
        String id = UUID.randomUUID().toString();
        FutureCallback<OpenAccount, Object> callback = new FutureCallback<>();
        commander.send(account.toCommand(id), callback);
        return callback.thenApply(r -> created(uri.path(ACCOUNT_ENDPOINT).path("/{id}").buildAndExpand(id).toUri()).build()).toCompletableFuture();
    }

    @PostMapping("/{accountId}/transaction")
    public Future makeTransaction(@PathVariable String accountId, @RequestBody MakeTransactionRequest transaction) {
        return commander.send(transaction.toCommand(accountId));
    }
}
