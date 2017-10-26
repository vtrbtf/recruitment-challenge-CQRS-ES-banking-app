package com.vtrbtf.minibank;

import java.math.BigDecimal;

public class Transaction {
    private final String name;
    private final BigDecimal value;

    public Transaction(String name, BigDecimal value) {
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
