package com.vtrbtf.minibank.client.application.command;

import lombok.Value;


@Value
public class EnrollClient {
    String name;
    String type;
    String CPF;
    String CNPJ;
}
