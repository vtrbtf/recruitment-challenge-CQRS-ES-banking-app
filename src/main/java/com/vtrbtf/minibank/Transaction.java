package com.vtrbtf.minibank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Transaction {
    private final String name;
    private final BigDecimal value;

    @JsonCreator
    public Transaction(@JsonProperty("name") String name, @JsonProperty("value") BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
