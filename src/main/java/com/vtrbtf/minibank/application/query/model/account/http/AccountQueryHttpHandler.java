package com.vtrbtf.minibank.application.query.model.account.http;

import com.vtrbtf.minibank.application.query.model.account.http.payload.GetAccountSummary;
import com.vtrbtf.minibank.application.query.model.account.http.payload.TransactionHistory;
import com.vtrbtf.minibank.application.query.model.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController @RequestMapping("/clients/{clientId}/accounts")
public class AccountQueryHttpHandler {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/{accountId}")
    public ResponseEntity<GetAccountSummary> accountSummary(@PathVariable String accountId) {
        return ResponseEntity.ok(new GetAccountSummary(accountRepository.get(accountId)));
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<TransactionHistory> accountHistory(@PathVariable String accountId) {
        return ResponseEntity.ok(new TransactionHistory(accountRepository.get(accountId)));
    }

}
