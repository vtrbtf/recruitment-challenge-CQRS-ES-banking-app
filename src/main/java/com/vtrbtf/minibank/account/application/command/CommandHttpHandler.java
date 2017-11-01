package com.vtrbtf.minibank.account.application.command;

import com.vtrbtf.minibank.account.aggregate.Account;
import com.vtrbtf.minibank.account.aggregate.transaction.Transaction;
import com.vtrbtf.minibank.account.application.command.model.MakeTransaction;
import com.vtrbtf.minibank.account.application.command.model.OpenAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.emptyList;
import static java.util.UUID.randomUUID;

@RestController("/account")
public class CommandHttpHandler {

    @PostMapping("/")
    public ResponseEntity openAccount(@RequestBody OpenAccount account) {
        return ResponseEntity.ok().location(URI.create(id)).build();
    }

    @PostMapping("/{accountId}/transaction")
    public ResponseEntity makeTransaction(@PathVariable String accountId, @RequestBody MakeTransaction transaction) {
        return ResponseEntity.ok().build();
    }

}
