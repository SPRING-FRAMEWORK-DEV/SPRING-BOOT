package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		repository.findAll().forEach(users::add);
		return users;
	}

	public User getById(String id) {
		return repository.findOne(id);
	}

	public void addAll() {
		List<User> user = Arrays.asList(new User("", "fname-1", "lname-1"), new User("", "fname-2", "lname-2"),
				new User("", "fname-3", "lname-3"), new User("", "fname-4", "lname-4"));

		repository.save(user);
	}

	public void save(User user) {
		repository.save(user);
	}

	public void deleteById(String userId) {
		repository.delete(userId);
	}

}
