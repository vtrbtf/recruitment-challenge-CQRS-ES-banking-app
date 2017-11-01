package com.vtrbtf.minibank.account.application.command;

import com.vtrbtf.minibank.account.application.command.model.MakeTransaction;
import com.vtrbtf.minibank.account.application.command.model.OpenAccount;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@RestController @RequestMapping("/account")
public class AccountCommandHttpHandler {
    @Autowired CommandGateway commander;

    @PostMapping("/")
    public Future<?> openAccount(@RequestBody OpenAccount account) {
        return commander.send(account);
    }

    @PostMapping("/{accountId}/transaction")
    public ResponseEntity makeTransaction(@PathVariable String accountId, @RequestBody MakeTransaction transaction) {
        return ResponseEntity.ok().build();
    }

}
