package com.vtrbtf.minibank.application.transaction;

import com.vtrbtf.minibank.application.holder.CreateHolderResponse;
import com.vtrbtf.minibank.core.domain.holder.Holder;
import com.vtrbtf.minibank.core.domain.transaction.Transaction;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static com.vtrbtf.minibank.MinibankApplication.storage;
import static java.util.UUID.randomUUID;

@Value
@RestController
public class TransactionRequestHandler {

    @PostMapping("/holder/{ownerId}/account/{accountId}/transaction")
    public ResponseEntity<CreateTransactionResponse> postTransaction(@PathVariable String ownerId,
                                                                     @PathVariable String accountId,
                                                                     @RequestBody CreateTransactionRequest transaction) {

        String id = randomUUID().toString();

        storage.put(id, new Holder(id, holder.getName(), holder.getType(), Collections.emptyList()));

        return ResponseEntity.ok().
                location(URI.create(id)).
                body(new CreateHolderResponse(id));

        storage.get(ownerId).getAccounts().stream().
                filter(account -> account.getId().equals(accountId)).
                findFirst().
                ifPresent(account -> account.getTransactions().add(new Transaction()));

        return transaction;
    }

    @GetMapping("/holder/{ownerId}/account/{accountId}/transaction/{transactionId}")
    public ResponseEntity<GetTransactionResponse> getTransaction(@PathVariable String ownerId,
                                                                 @PathVariable String accountId,
                                                                 @PathVariable String transactionId) {
        return storage.get(ownerId).getAccounts().stream().
                filter(account -> account.getId().equals(accountId)).
                findFirst().
                flatMap(account ->
                        account.getTransactions().
                                stream().
                                filter( transaction -> transaction.getId().equals(transactionId)).findFirst()).
                map(ResponseEntity::ok).orElse((ResponseEntity.<Transaction>notFound().build()));
    }

    @GetMapping("/holder/{ownerId}/account/{accountId}/transaction")
    public ResponseEntity<List<GetTransactionResponse>> listTransactions(@PathVariable String ownerId, @PathVariable String accountId) {
        return storage.get(ownerId).getAccounts().stream().
                filter(account -> account.getId().equals(accountId)).
                findFirst().
                map(account -> account.getTransactions()).
                map(ResponseEntity::ok).orElse((ResponseEntity.<Transaction>notFound().build()));
    }

}
