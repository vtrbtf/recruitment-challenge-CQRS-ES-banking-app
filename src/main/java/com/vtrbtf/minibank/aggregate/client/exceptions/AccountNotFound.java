package com.vtrbtf.minibank.aggregate.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFound extends RuntimeException {
    public AccountNotFound() {
        super("Account was not found");
    }
}
