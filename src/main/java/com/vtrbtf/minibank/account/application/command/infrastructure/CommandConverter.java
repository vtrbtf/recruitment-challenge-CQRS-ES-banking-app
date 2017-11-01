package com.vtrbtf.minibank.account.application.command.infrastructure;

import com.vtrbtf.minibank.account.application.command.model.Command;

public interface CommandConverter<T extends Command> {
    public T toCommand(String id);
}
