package com.vtrbtf.minibank.application.transaction;

import lombok.Data;
import lombok.Value;
import lombok.experimental.PackagePrivate;

import java.math.BigDecimal;

@Data @PackagePrivate
class CreateTransactionRequest {
    private String name;
    private BigDecimal value;
}
