package com.vtrbtf.minibank.application.command.model.client.http.payload;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vtrbtf.minibank.application.command.model.CommandConverter;
import com.vtrbtf.minibank.application.command.model.account.http.payload.MakeWithdrawRequest;
import com.vtrbtf.minibank.application.command.model.client.EnrollClient;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EnrollPersonRequest.class, name = "PERSON"),
        @JsonSubTypes.Type(value = MakeWithdrawRequest.class, name = "COMPANY")
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class EnrollClientRequest implements CommandConverter<EnrollClient> {
    String name;
}
