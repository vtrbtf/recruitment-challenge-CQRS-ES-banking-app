package com.vtrbtf.minibank.application.command.infrastructure;

import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.UUID;

public interface CommandHTTPHandler {

    default String UUID() {
        return UUID.randomUUID().toString();
    }

    default <T> FutureCallback<T, Object> send(CommandGateway commander, T command) {
        FutureCallback<T, Object> callback = new FutureCallback<>();
        commander.send(command, callback);
        return callback;
    }
}
