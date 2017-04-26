package com.app.config;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.spring.utils.LoggerManager;

@SpringBootApplication
@Import(AppRootConfig.class)
@ComponentScan(basePackages = "com.spring")
// used only in deployment in external tomcat
public class SpringBootWebApplication extends SpringBootServletInitializer {

	static Logger logger = new LoggerManager(
			SpringBootWebApplication.class.getCanonicalName()).getLogger();

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {

		logger.info("\n+++++++++++++++\n+++++++++++++++\n+++++++++++++++\n+++++++++++++++");

		logger.info("Executing Spring Boot Main");

		logger.info("\n+++++++++++++++\n+++++++++++++++\n+++++++++++++++\n+++++++++++++++");

	
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}