package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeeayrollApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(EmployeeayrollApplication.class, args);
		log.info("Employee app started in the {} Environment", context.getEnvironment().getProperty("environment"));
		log.info("Employee DB User is{}", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
