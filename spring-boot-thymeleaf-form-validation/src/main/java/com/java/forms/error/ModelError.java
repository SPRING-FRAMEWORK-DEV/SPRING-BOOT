package com.java.forms.error;

public class ModelError {

	private String fieldName;
	private String message;

	public ModelError(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ModelError [fieldName=" + fieldName + ", message=" + message + "]";
	}

}
