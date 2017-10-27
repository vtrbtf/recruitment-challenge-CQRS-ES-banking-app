package com.vtrbtf.minibank.core.domain.holder;

import com.vtrbtf.minibank.core.domain.account.Account;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Holder {
    private final String id;
    private final String name;
    private final String type;
    private final List<Account> accounts;
    private String CPF; //TODO: Brazillian model or should I try to abstract ?
    private String CNPJ; //TODO: Brazillian model or should I try to abstract ?

}
