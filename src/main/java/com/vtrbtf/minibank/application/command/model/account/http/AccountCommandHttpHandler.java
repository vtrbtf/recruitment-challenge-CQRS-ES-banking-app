package com.vtrbtf.minibank.application.command.model.account.http;

import com.vtrbtf.minibank.application.command.infrastructure.CommandHTTPHandler;
import com.vtrbtf.minibank.application.command.model.account.http.payload.MakeTransactionRequest;
import com.vtrbtf.minibank.application.command.model.account.http.payload.OpenAccountRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.Future;

import static org.springframework.http.ResponseEntity.created;

@RestController @RequestMapping("/clients/{clientId}/accounts")
public class AccountCommandHttpHandler implements CommandHTTPHandler {

    @Autowired CommandGateway commander;

    @PostMapping
    public Future openAccount(@PathVariable String clientId, @RequestBody OpenAccountRequest account,
                              UriComponentsBuilder uri) {
        String id = UUID();
        return send(commander, account.withClientId(clientId).toCommand(id)).
                thenApply(r -> created(locationURI(clientId, id, uri)).build()).toCompletableFuture();
    }

    @PostMapping("/{accountId}/transactions")
    public Future makeTransaction(@PathVariable String clientId, @PathVariable String accountId,
                                  @RequestBody MakeTransactionRequest transaction) {
        return send(commander,transaction.withClientId(clientId).toCommand(accountId)).toCompletableFuture();
    }

    private URI locationURI(@PathVariable String clientId, String id, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/clients/{clientId}/accounts").path("/{accountId}").buildAndExpand(clientId,id).toUri();
    }
}
