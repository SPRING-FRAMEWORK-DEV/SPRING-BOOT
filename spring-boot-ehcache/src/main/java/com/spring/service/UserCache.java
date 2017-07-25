package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.spring.model.EmployeeModel;
import com.spring.repository.IEmployeeRepository;

@Component
public class UserCache {

	@Autowired
	IEmployeeRepository employeeRepository;

	@Cacheable(value = "userCache", key = "#name")
	public EmployeeModel getUser(String name) {
		System.out.println("from database");
		return employeeRepository.findByName(name);
	}
}
