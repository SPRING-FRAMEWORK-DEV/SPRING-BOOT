package com.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.java")
@Import(AppConfig.class)
public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppMain.class, args);

		String beans[] = context.getBeanDefinitionNames();

		for (String bean : beans) {
			System.out.println(bean);
		}
	}

}
