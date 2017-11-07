package com.vtrbtf.minibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.vtrbtf.minibank")
public class MinibankApplication {
    public static void main(String[] args) {
        SpringApplication.run(MinibankApplication.class, args);
    }
}