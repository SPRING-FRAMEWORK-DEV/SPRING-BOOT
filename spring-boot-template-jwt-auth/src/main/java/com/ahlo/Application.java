package com.ahlo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("dev")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
