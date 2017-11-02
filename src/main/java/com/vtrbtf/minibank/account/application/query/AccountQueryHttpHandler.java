package com.vtrbtf.minibank.account.application.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController @RequestMapping("/account")
public class AccountQueryHttpHandler {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/{accountId}")
    public ResponseEntity accountSummary(@PathVariable String accountId) {
        return ResponseEntity.ok(accountRepository.get(accountId));
    }

}
