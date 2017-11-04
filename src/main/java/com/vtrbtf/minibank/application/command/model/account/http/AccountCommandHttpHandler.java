package com.vtrbtf.minibank.application.command.model.account.http;

import com.vtrbtf.minibank.application.command.infrastructure.CommandHTTPHandler;
import com.vtrbtf.minibank.application.command.model.account.http.payload.MakeTransactionRequest;
import com.vtrbtf.minibank.application.command.model.account.http.payload.OpenAccountRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.Future;

import static org.springframework.http.ResponseEntity.created;

@RestController @RequestMapping(AccountCommandHttpHandler.ACCOUNT_ENDPOINT)
public class AccountCommandHttpHandler implements CommandHTTPHandler {
    public static final String ACCOUNT_ENDPOINT = "/clients/{clientId}/accounts";

    @Autowired CommandGateway commander;

    @PostMapping
    public Future openAccount(@PathVariable String clientId, @RequestBody OpenAccountRequest account,
                              UriComponentsBuilder uri) {
        String id = UUID();
        return send(commander, account.withClientId(clientId).toCommand(id)).
                thenApply(r -> {
                    return created(uri.path(ACCOUNT_ENDPOINT).path("/{id}").buildAndExpand(clientId,id).toUri()).
                            build();
                }).toCompletableFuture();
    }

    @PostMapping("/{accountId}/transactions")
    public Future makeTransaction(@PathVariable String clientId, @PathVariable String accountId,
                                  @RequestBody MakeTransactionRequest transaction) {
        return send(commander, transaction.withClientId(clientId).toCommand(accountId)).toCompletableFuture();
    }
}
