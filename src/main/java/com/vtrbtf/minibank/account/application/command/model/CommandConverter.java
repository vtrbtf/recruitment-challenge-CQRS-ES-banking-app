package com.vtrbtf.minibank.account.application.command.model;

public interface CommandConverter<T extends Command> {
    T toCommand(String id);
}
