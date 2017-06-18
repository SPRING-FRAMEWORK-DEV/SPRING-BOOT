package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootMainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = SpringApplication.run(SpringBootMainApplication.class, args);

		String beans[] = context.getBeanDefinitionNames();

		for (String bean : beans) {
			System.out.println(bean);
		}

	}

}
