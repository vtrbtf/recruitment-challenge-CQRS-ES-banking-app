package com.vtrbtf.minibank.account.application.command.infrastructure;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vtrbtf.minibank.account.application.command.model.MakeTransaction;
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
@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class MakeTransactionRequest implements CommandConverter<MakeTransaction> {
    String description;
    BigDecimal value;
}
