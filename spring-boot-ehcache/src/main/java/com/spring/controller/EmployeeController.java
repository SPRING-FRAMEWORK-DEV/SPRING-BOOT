package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.EmployeeModel;
import com.spring.service.UserCache;

@RestController
@RequestMapping("/employee/search/")
public class EmployeeController {

	@Autowired
	UserCache userCache;

	@GetMapping("/{name}")
	public EmployeeModel getEmployee(@PathVariable final String name) {
		return userCache.getUser(name);
	}

}
