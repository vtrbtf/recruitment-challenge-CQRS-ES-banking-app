package com.vtrbtf.minibank.core.aggregate.client;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.List;

@Value @NonFinal
public class Client {
    String id;
    List<String> accounts;
}
