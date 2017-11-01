package com.vtrbtf.minibank.account.application.query;

import com.vtrbtf.minibank.account.application.query.model.GetAccountSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/account")
public class QueryHttpHandler {

    @GetMapping("/{accountId}")
    public ResponseEntity<GetAccountSummary> getAccount(@PathVariable String accountId) {
        return storage.get(accountId).
                map(GetAccountSummary::new).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.<GetAccountSummary>notFound().build());
    }

}
