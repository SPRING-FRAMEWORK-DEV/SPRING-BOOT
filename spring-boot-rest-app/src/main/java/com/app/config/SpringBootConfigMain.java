package com.app.config;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppRootConfig.class)
public class SpringBootConfigMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication app = new SpringApplication(
				SpringBootConfigMain.class);
		// app.setBannerMode(Banner.Mode.OFF);
		ApplicationContext ctx = app.run(args);

		String[] beanNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanNames);

		System.out.println("=========Created Beans=========:"
				+ beanNames.length);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}
