package com.vtrbtf.minibank;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.vtrbtf.minibank")
public class MinibankApplication {
	public static void main(String[] args) {
		SpringApplication.run(MinibankApplication.class, args);
	}

	@Bean
	public Module parameterNamesModule() {
		return new ParameterNamesModule();
	}

	@Bean
	public Module jdk8Module() {
		return new Jdk8Module();
	}
}
