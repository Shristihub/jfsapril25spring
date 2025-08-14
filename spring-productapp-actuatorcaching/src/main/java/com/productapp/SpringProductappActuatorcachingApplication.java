package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringProductappActuatorcachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappActuatorcachingApplication.class, args);
	}

}
