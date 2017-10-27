package com.vtrbtf.minibank.application.account;

import com.vtrbtf.minibank.core.domain.account.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;

import static com.vtrbtf.minibank.MinibankApplication.storage;
import static java.util.UUID.randomUUID;

@RestController
public class AccountRequestHandler {

    @GetMapping("/holder/{ownerId}/account/{accountId}")
    public ResponseEntity<GetAccountResponse> getAccount(@PathVariable String ownerId, @PathVariable String accountId) {
        return storage.get(ownerId).
                getAccounts().
                stream().
                filter(account -> account.getId().equals(accountId)).
                findFirst().
                map(GetAccountResponse::new).
                map(response -> ResponseEntity.ok(response)).
                orElse(ResponseEntity.<GetAccountResponse>notFound().build());
    }

    @PostMapping("/holder/{ownerId}/account")
    public ResponseEntity<CreateAccountResponse> postAccount(@PathVariable String ownerId, @RequestBody CreateAccountRequest account) {
        String id = randomUUID().toString();

        storage.get(ownerId).getAccounts().add(new Account(id, account.getName(), Collections.emptyList()));

        return ResponseEntity.ok().
                location(URI.create(id)).
                body(new CreateAccountResponse(id));

    }
}
