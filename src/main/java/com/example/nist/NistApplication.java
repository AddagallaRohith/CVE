package com.example.nist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NistApplication {

	public static void main(String[] args) {
		SpringApplication.run(NistApplication.class, args);
	}

}
