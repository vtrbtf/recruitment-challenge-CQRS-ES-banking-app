package com.vtrbtf.minibank.account.application.command.model;

import lombok.Value;

@Value
public class OpenAccount {
    String name;
    String type;
}
