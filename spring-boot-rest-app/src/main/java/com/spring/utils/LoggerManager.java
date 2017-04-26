package com.spring.utils;

import org.apache.log4j.Logger;

public class LoggerManager {

	private String className;

	private Logger logger = null;

	public LoggerManager(String className) {
		super();
		this.className = className;
		logger = Logger.getLogger(className);
	}

	public String getClassName() {
		return className;
	}

	public Logger getLogger() {
		return logger;
	}

}
