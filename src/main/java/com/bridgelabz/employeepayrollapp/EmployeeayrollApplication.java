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

		log.info("Employee payroll app started in {} Environment", context.getEnvironment().getProperty("environment"));
	}

}