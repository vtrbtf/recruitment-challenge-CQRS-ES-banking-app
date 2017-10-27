package com.vtrbtf.minibank.application.holder;

import com.vtrbtf.minibank.core.domain.holder.Holder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.UUID;

import static com.vtrbtf.minibank.MinibankApplication.storage;
import static java.util.UUID.randomUUID;

@RestController
public class HolderRequestHandler {

    @GetMapping("/holder/{ownerId}")
    public ResponseEntity<GetHolderResponse> getHolder(@PathVariable String ownerId) {
        return ResponseEntity.ok(new GetHolderResponse(storage.get(ownerId)));
    }

    @PostMapping("/holder")
    public ResponseEntity<CreateHolderResponse> postHolder(@RequestBody CreateHolderRequest holder) {
        String id = randomUUID().toString();

        storage.put(id, new Holder(id, holder.getName(), holder.getType(), Collections.emptyList()));

        return ResponseEntity.ok().
                location(URI.create(id)).
                body(new CreateHolderResponse(id));
    }
}
