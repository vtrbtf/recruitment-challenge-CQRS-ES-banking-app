package com.vtrbtf.minibank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    private Map<String, Account> storage = new HashMap<>();

    @GetMapping("/account/{owner}")
    public Account loadOwner(@PathVariable String owner) {
        return storage.get(owner);
    }

    @PostMapping("/account/{owner}/transaction")
    public Transaction addTransaction(@PathVariable String owner, @RequestBody Transaction transaction) {
        storage.get(owner).getTransactions().add(transaction);
        return transaction;
    }

    @PostMapping("/account")
    public Account addAccount(@RequestBody Account account) {
        return storage.put(account.getOwner(), account);
    }
}
