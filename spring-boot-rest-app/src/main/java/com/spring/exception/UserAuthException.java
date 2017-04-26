package com.spring.exception;

public class UserAuthException extends RuntimeException implements
		IAppBaseException {

	public UserAuthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
