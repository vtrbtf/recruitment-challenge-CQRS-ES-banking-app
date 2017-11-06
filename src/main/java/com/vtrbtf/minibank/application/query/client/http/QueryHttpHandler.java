package com.vtrbtf.minibank.application.query.client.http;

import com.vtrbtf.minibank.application.query.client.account.repository.AccountRepository;
import com.vtrbtf.minibank.application.query.client.http.payload.GetAccountSummary;
import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;
import com.vtrbtf.minibank.application.query.client.http.payload.TransactionHistory;
import com.vtrbtf.minibank.application.query.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@Value @RequiredArgsConstructor(onConstructor=@__({@Autowired}))
public class QueryHttpHandler {
    ClientRepository clientRepository;
    AccountRepository accountRepository;

    @GetMapping("/{clientId}")
    public ResponseEntity<GetClient> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(clientRepository.get(clientId).toPayload());
    }

    @GetMapping("{clientId}/accounts/{accountId}")
    public ResponseEntity<GetAccountSummary> accountSummary(@PathVariable String accountId) {
        return ResponseEntity.ok(new GetAccountSummary(accountRepository.get(accountId)));
    }

    @GetMapping("{clientId}/accounts/{accountId}/transactions")
    public ResponseEntity<TransactionHistory> accountHistory(@PathVariable String accountId) {
        return ResponseEntity.ok(new TransactionHistory(accountRepository.get(accountId)));
    }
}
