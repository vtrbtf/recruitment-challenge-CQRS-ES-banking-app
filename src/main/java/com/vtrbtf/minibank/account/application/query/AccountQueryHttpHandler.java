package com.vtrbtf.minibank.account.application.query;

import com.vtrbtf.minibank.account.application.query.model.GetAccountSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/account")
public class AccountQueryHttpHandler {

    @GetMapping("/{accountId}")
    public ResponseEntity<GetAccountSummary> accountSummary(@PathVariable String accountId) {
        return ResponseEntity.ok().build();
    }

}
