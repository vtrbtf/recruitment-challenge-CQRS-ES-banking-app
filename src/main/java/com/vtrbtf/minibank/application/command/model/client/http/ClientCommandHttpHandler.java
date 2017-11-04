package com.vtrbtf.minibank.application.command.model.client.http;

import com.vtrbtf.minibank.application.command.model.client.EnrollClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static java.util.UUID.randomUUID;

@RestController @RequestMapping("/client")
public class ClientCommandHttpHandler {

    @PostMapping("/client")
    public ResponseEntity postClient(@RequestBody EnrollClient client) {
        String id = randomUUID().toString();
        return ResponseEntity.ok().location(URI.create(id)).build();
    }
}
