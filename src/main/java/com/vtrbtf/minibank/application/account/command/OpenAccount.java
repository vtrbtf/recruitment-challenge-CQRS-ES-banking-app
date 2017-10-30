package com.vtrbtf.minibank.application.account.command;

import lombok.Value;

@Value
public class OpenAccount {
    String name;
    String type;
}
