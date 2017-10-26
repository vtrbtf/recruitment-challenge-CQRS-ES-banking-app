package com.vtrbtf.minibank;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controller {
    private Map<String, Holder> storage = new HashMap<>();

    @GetMapping("/holder/{owner}")
    public Holder loadHolder(@PathVariable String owner) {
        return storage.get(owner);
    }

    @PostMapping("/holder")
    public Holder addHolder(@RequestBody Holder holder) {
        return storage.put(holder.getName(), holder);
    }

    @GetMapping("/holder/{owner}/account/{id}")
    public Account loadOwner(@PathVariable String owner, @PathVariable String id) {
        return storage.get(owner).getAccounts().stream().filter(account -> account.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("account not found"));
    }

    @PostMapping("/holder/{owner}/account")
    public Account addAccount(@PathVariable String owner, @RequestBody Account account) {
        storage.get(owner).getAccounts().add(account);
        return account;
    }

    @PostMapping("/holder/{owner}/account/{id}/transaction")
    public Transaction addTransaction(@PathVariable String owner, @PathVariable String id,
                                      @RequestBody Transaction transaction) {
        storage.get(owner).getAccounts().stream().
                filter(account -> account.getId().equals(id)).
                findFirst().
                ifPresent(account -> account.getTransactions().add(transaction));

        return transaction;
    }
}
