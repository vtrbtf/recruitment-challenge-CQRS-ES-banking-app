package com.vtrbtf.minibank.client.application.query;

import com.vtrbtf.minibank.client.aggregate.Client;
import com.vtrbtf.minibank.client.application.command.model.EnrollClient;
import com.vtrbtf.minibank.client.application.query.model.GetPersonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.UUID.randomUUID;

@RestController @RequestMapping("/client")
public class ClientQueryHttpHandler {
    public static Map<String, Client> storage = new ConcurrentHashMap<>();

    @GetMapping("{clientId}")
    public ResponseEntity<GetPersonClient> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(new GetPersonClient());
    }
}
