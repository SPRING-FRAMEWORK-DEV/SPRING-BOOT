package com.expedia.events.error;

import org.springframework.validation.BindingResult;

public class InputFieldDataNotValidException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5216745990713734656L;
	
	
	private BindingResult bindingResult;

	
	public InputFieldDataNotValidException(BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;
	}


	public InputFieldDataNotValidException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BindingResult getBindingResult() {
		return bindingResult;
	}


	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	
	
	
}
