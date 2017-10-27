package com.vtrbtf.minibank.application.holder;

import lombok.Value;
import lombok.experimental.PackagePrivate;


@Value
@PackagePrivate
class CreateHolderRequest {
    String name;
    String type;
    String CPF;
    String CNPJ;
}
