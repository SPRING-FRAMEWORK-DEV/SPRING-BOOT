package com.spring.exception;

public class ErrorMessage {

	private String errorCode;
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorMessage [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
