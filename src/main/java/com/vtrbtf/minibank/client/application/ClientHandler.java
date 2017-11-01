package com.vtrbtf.minibank.client.application;

import com.vtrbtf.minibank.client.application.command.EnrollClient;
import com.vtrbtf.minibank.client.application.query.GetPersonClient;
import com.vtrbtf.minibank.client.aggregate.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.UUID.randomUUID;

@RestController("/client")
public class ClientHandler {
    public static Map<String, Client> storage = new ConcurrentHashMap<>();

    @GetMapping("{clientId}")
    public ResponseEntity<GetPersonClient> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(new GetPersonClient());
    }

    @PostMapping("/client")
    public ResponseEntity postClient(@RequestBody EnrollClient client) {
        String id = randomUUID().toString();
        storage.put(id, new Client(id, Collections.emptyList()));
        return ResponseEntity.ok().
                location(URI.create(id)).build();
    }
}