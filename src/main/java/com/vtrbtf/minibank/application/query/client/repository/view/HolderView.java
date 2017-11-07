package com.vtrbtf.minibank.application.query.client.repository.view;

import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;

public interface HolderView {
    GetClient toPayload(ClientView view);
}
