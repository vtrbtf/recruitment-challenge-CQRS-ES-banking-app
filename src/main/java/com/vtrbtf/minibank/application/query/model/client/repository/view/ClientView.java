package com.vtrbtf.minibank.application.query.model.client.repository.view;

import com.vtrbtf.minibank.application.query.model.client.http.payload.GetClient;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ClientView {
    String id;
    public abstract GetClient toPayload();
}
