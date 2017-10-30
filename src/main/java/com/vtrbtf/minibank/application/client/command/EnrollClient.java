package com.vtrbtf.minibank.application.client.command;

import lombok.Value;
import lombok.experimental.PackagePrivate;


@Value
public class EnrollClient {
    String name;
    String type;
    String CPF;
    String CNPJ;
}
