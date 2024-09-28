package com.struggles_hovel.SH_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShBackendApplication {

	public static void main(String[] args) {

		System.out.println("Database URL: " + System.getenv("DB_URL"));
		System.out.println("Database Username: " + System.getenv("DB_USERNAME"));


		SpringApplication.run(ShBackendApplication.class, args);
	}
}