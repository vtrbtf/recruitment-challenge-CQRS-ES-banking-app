package com.vtrbtf.minibank.client.application.command.model;

import lombok.Value;


@Value
public class EnrollClient {
    String name;
    String type;
    String CPF;
    String CNPJ;
}
