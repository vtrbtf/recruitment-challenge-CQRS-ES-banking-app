package com.vtrbtf.minibank.application.command.model;

public interface CommandConverter<T extends Command> {
    T toCommand(String id);
}
