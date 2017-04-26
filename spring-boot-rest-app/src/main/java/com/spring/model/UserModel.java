package com.spring.model;

import java.util.Arrays;

public class UserModel {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", password=" + password + "]";
	}
		
	

}
