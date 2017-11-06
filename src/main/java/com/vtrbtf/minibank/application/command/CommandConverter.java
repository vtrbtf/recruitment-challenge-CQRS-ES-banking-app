package com.vtrbtf.minibank.application.command;

public interface CommandConverter<T extends Command> {
    T toCommand(String id);
}
