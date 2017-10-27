package com.vtrbtf.minibank.application.account;

import lombok.Value;
import lombok.experimental.PackagePrivate;

@Value @PackagePrivate
class CreateAccountRequest {
    String name;
    String type;
}
