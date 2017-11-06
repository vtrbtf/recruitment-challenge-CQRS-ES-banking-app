package com.vtrbtf.minibank.application.command.client.http.payload;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vtrbtf.minibank.application.command.CommandConverter;
import com.vtrbtf.minibank.application.command.client.MakeTransaction;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MakeDepositRequest.class, name = "DEPOSIT"),
        @JsonSubTypes.Type(value = MakeWithdrawRequest.class, name = "WITHDRAW")
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class MakeTransactionRequest implements CommandConverter<MakeTransaction> {
    String clientId;
    String description;
    BigDecimal value;

    public MakeTransactionRequest withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

}
