package com.vtrbtf.minibank;

import java.util.ArrayList;
import java.util.List;

public class Holder {
    private final String name;
    private final String type;
    private String CPF; //TODO: Brazillian model or should I try to abstract ?
    private String CNPJ; //TODO: Brazillian model or should I try to abstract ?
    private List<Account> accounts = new ArrayList<>();

    public Holder(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getType() {
        return type;
    }

    public String getCPF() {
        return CPF;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
