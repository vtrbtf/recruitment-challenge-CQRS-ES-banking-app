package com.vtrbtf.minibank.application.query.model.client.http;

import com.vtrbtf.minibank.application.query.model.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.model.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/clients")
public class ClientQueryHttpHandler {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/{clientId}")
    public ResponseEntity<GetClient> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(clientRepository.get(clientId).toPayload());
    }
}
