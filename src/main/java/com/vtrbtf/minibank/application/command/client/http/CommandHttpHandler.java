package com.vtrbtf.minibank.application.command.client.http;

import com.vtrbtf.minibank.application.command.client.http.payload.EnrollClientRequest;
import com.vtrbtf.minibank.application.command.client.http.payload.MakeTransactionRequest;
import com.vtrbtf.minibank.application.command.client.http.payload.OpenAccountRequest;
import lombok.Value;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.Future;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/clients")
@Value
public class CommandHttpHandler {

    CommandGateway commander;

    @Autowired
    public CommandHttpHandler(CommandGateway commander) {
        this.commander = commander;
    }

    @PostMapping
    public Future enrollClient(@RequestBody EnrollClientRequest client, UriComponentsBuilder uri) {
        String id = UUID();
        return send(client.toCommand(id)).
                thenApply(r -> created(locationURI(id, uri)).build()).toCompletableFuture();
    }

    @PostMapping("{clientId}/accounts")
    public Future openAccount(@PathVariable String clientId, @RequestBody OpenAccountRequest account,
                              UriComponentsBuilder uri) {
        String id = UUID();
        return send(account.withClientId(clientId).toCommand(id)).
                thenApply(r -> created(locationURI(clientId, id, uri)).build()).toCompletableFuture();
    }

    @PostMapping("/{accountId}/transactions")
    public Future makeTransaction(@PathVariable String clientId, @PathVariable String accountId,
                                  @RequestBody MakeTransactionRequest transaction) {

        return send(transaction.withClientId(clientId).toCommand(accountId)).toCompletableFuture();
    }

    private URI locationURI(@PathVariable String clientId, String accountId, UriComponentsBuilder uriBuilder) {
        return basePath(uriBuilder).path("/accounts/{accountId}").buildAndExpand(clientId, accountId).toUri();
    }

    private URI locationURI(@PathVariable String clientId, UriComponentsBuilder uriBuilder) {
        return basePath(uriBuilder).buildAndExpand(clientId).toUri();
    }

    private UriComponentsBuilder basePath(UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/clients/{clientId}");
    }

    private String UUID() {
        return UUID.randomUUID().toString();
    }

    private <T> FutureCallback<T, Object> send(T command) {
        FutureCallback<T, Object> callback = new FutureCallback<>();
        commander.send(command, callback);
        return callback;
    }
}
