package com.vtrbtf.minibank.application.account;

import com.vtrbtf.minibank.application.account.command.OpenAccount;
import com.vtrbtf.minibank.application.account.command.MakeTransaction;
import com.vtrbtf.minibank.application.account.query.GetAccount;
import com.vtrbtf.minibank.core.aggregate.account.Account;
import com.vtrbtf.minibank.core.aggregate.account.transaction.Transaction;
import com.vtrbtf.minibank.core.aggregate.account.transaction.Transactions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.emptyList;
import static java.util.UUID.randomUUID;

@RestController("/account")
public class AccountHandler {
    public static Map<String, Optional<Account>> storage = new ConcurrentHashMap<>();

    @PostMapping("/")
    public ResponseEntity postAccount(@RequestBody OpenAccount account) {
        String id = randomUUID().toString();

        storage.put(id, Optional.of(new Account(id, account.getName(), account.getName(), emptyList())));

        return ResponseEntity.ok().location(URI.create(id)).build();
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<GetAccount> getAccount(@PathVariable String accountId) {
        return storage.get(accountId).
                map(GetAccount::new).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.<GetAccount>notFound().build());
    }

    @PostMapping("/{accountId}/transaction")
    public ResponseEntity postTransaction(@PathVariable String accountId,
                                          @RequestBody MakeTransaction transaction) {

        storage.get(accountId).ifPresent( account -> account.getTransactions().add(new Transaction(transaction.getDescription(), transaction.getValue())));
        return ResponseEntity.ok().build();
    }

}
