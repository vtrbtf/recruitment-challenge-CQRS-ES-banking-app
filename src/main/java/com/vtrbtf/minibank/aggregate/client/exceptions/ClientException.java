package com.vtrbtf.minibank.aggregate.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ClientException extends RuntimeException {
    public ClientException(String message) {
        super(message);
    }
}
