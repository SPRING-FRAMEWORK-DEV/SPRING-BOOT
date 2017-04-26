package com.app.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.spring.utils.LoggerManager;

//@Configuration // not required as we have imported AppRootConfig class in main class and main class has SpringBootAnnotation that applied @Configuration too.
// @PropertySource("classpath:database.properties")
public class AppRootConfig {

	Logger logger = new LoggerManager(getClass().getCanonicalName())
			.getLogger();

	public AppRootConfig() {
		super();
		// TODO Auto-generated constructor stub
		logger.info("============PropertiesWithJavaConfig()===========");
	}

	// DataSource configuration
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Bean(name = "MySQLDataSource")
	public DataSource dataSource() {
		logger.info("=========creating datasource with: " + url + "-"
				+ username + "=============");
		return new DriverManagerDataSource(url, username, password);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasenames("messages");
		messageSource.setDefaultEncoding("UTF-8");

		return messageSource;
	}

}
