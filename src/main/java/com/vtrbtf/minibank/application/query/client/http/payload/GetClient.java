package com.vtrbtf.minibank.application.query.client.http.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtrbtf.minibank.application.query.client.http.QueryHttpHandler;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class GetClient extends ResourceSupport {
    List<String> accounts;

    public GetClient(String clientId, List<String> accounts) {
        add(linkTo(methodOn(QueryHttpHandler.class).getClient(clientId)).withSelfRel());
        add(linkTo(methodOn(QueryHttpHandler.class).account(clientId)).withRel("accounts"));
    }
}
