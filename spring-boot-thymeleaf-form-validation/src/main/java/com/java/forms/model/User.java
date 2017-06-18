package com.java.forms.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.java.forms.validator.Phone;

public class User {

	private int userId;

	@NotEmpty(message = "Required")
	@Size(min = 2, max = 4)
	private String firstName;

	@NotEmpty(message = "Required")
	@Size(min = 5, max = 7)
	private String lastName;

	@NotEmpty(message = "Required")
	@Email
	private String email;

	@NotEmpty(message = "Required")
	@Phone(message = "format is not valid")
	private String phoneNo;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User(int userId, String firstName, String lastName, String email, String phoneNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
