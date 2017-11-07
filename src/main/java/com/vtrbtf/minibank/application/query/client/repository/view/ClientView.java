package com.vtrbtf.minibank.application.query.client.repository.view;

import com.vtrbtf.minibank.aggregate.client.events.ClientEnrolled;
import com.vtrbtf.minibank.application.query.client.http.payload.GetClient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@BsonDiscriminator
public class ClientView {
    @BsonId
    String clientId;
    List<String> accounts;

    @BsonProperty(useDiscriminator = true)
    HolderView holder;

    public ClientView(ClientEnrolled e, HolderView holder) {
        clientId = e.getClientId();
        accounts = new ArrayList<>();
        this.holder = holder;
    }

    public GetClient toPayload() {
        return holder.toPayload(this);
    }
}
