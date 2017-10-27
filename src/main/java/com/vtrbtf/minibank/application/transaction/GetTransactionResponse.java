package com.vtrbtf.minibank.application.transaction;

import lombok.Value;
import lombok.experimental.PackagePrivate;

import java.math.BigDecimal;

@Value @PackagePrivate
class GetTransactionResponse {
    String name;
    BigDecimal value;
}
