package com.vtrbtf.minibank.application.query.client.repository.view;

import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ClientView {
    String id;

    public abstract GetClient toPayload();
}
