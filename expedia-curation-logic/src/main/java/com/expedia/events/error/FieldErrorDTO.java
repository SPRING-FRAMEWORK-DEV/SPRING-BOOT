package com.expedia.events.error;
public class FieldErrorDTO implements Comparable<FieldErrorDTO> {

	private String fieldName;
	private String message;

	public FieldErrorDTO(String fieldName, String message) {
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
		return "FieldErrorDTO [fieldName=" + fieldName + ", message=" + message + "]";
	}

	@Override
	public int compareTo(FieldErrorDTO o) {
		// TODO Auto-generated method stub
		return this.getFieldName().compareTo(o.getFieldName());
	}
	
	

}