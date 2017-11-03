package com.vtrbtf.minibank.client.application.command;

import com.vtrbtf.minibank.client.application.command.model.EnrollClient;
import com.vtrbtf.minibank.client.application.query.model.GetPersonClient;
import com.vtrbtf.minibank.client.aggregate.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.UUID.randomUUID;

@RestController @RequestMapping("/client")
public class ClientCommandHttpHandler {

    @PostMapping("/client")
    public ResponseEntity postClient(@RequestBody EnrollClient client) {
        String id = randomUUID().toString();
        return ResponseEntity.ok().location(URI.create(id)).build();
    }
}
