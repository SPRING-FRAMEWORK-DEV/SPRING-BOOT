package com.java.forms.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.forms.model.User;

@Component
public class UserManager {

	List<User> userList = null;

	public UserManager() {
		super();
		// TODO Auto-generated constructor stub
		createUsers();
	}

	public void createUsers() {

		userList = new ArrayList<User>();
		for (int i = 1; i <= 10; i++) {
			userList.add(new User(i, "FirstName" + i, "LastName" + i, "Email" + i, "PhoneNo" + i));
		}
	}

	public List<User> fetchAll() {
		return userList;
	}

	public User getById(int id) {
		return userList.get(id - 1);
	}
}
