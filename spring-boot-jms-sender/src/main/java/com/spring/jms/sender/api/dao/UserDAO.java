package com.spring.jms.sender.api.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.spring.jms.sender.api.model.User;

@Repository
public class UserDAO {

	static List<User> users = null;
	static {
		users = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			users.add(new User(new Random().nextInt(2487254), "user" + i,
					"address" + i, "user" + i + "@gmail.com"));
		}
	}

	public List<User> getUsers() {
		return users;
	}
}
