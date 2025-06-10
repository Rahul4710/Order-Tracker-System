package com.thenxt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class OrderTrackerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderTrackerSystemApplication.class, args);
	}

}
