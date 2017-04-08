package com.spring.config;

import org.springframework.context.annotation.Import;

@Import(value = DataConfig.class)
public class AppConfig {

	public AppConfig() {
		super();
		// TODO Auto-generated constructor stub

		System.out.println("AppConfig");
	}

}
