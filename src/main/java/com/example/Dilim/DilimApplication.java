package com.example.Dilim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DilimApplication {

	public static void main(String[] args) {
		SpringApplication.run(DilimApplication.class, args);
	}
}
