package com.vtrbtf.minibank.application.command.model.client.http;

import com.vtrbtf.minibank.application.command.infrastructure.CommandHTTPHandler;
import com.vtrbtf.minibank.application.command.model.client.http.payload.EnrollClientRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.Future;

import static org.springframework.http.ResponseEntity.created;

@RestController @RequestMapping("/clients")
public class ClientCommandHttpHandler implements CommandHTTPHandler {

    @Autowired
    CommandGateway commander;

    @PostMapping
    public Future enrollClient(@RequestBody EnrollClientRequest client, UriComponentsBuilder uri) {
        String id = UUID();
        return send(commander, client.toCommand(id)).
                thenApply(r -> created(locationURI(id, uri)).build()).toCompletableFuture();
    }

    private URI locationURI(@PathVariable String clientId, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/clients/{clientId}").buildAndExpand(clientId).toUri();
    }

}
