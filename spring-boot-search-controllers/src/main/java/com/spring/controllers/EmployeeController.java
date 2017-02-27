package com.spring.controllers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.EmployeeModel;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	// note: same url cannot be reused twice anywhere in a given application
	// scope.
	// for example i have used / in below code. you cannot use / again in
	// EmployeeController or DepartmentController or anywhere in the
	// application.
	
	@RequestMapping("/")
	private String getIndex() {
		return "This is employee controller";
	}

	@RequestMapping("get-employee-{idx}-data")
	private EmployeeModel getEmployeeById(@PathVariable("idx") String employeeId) {
		return service.getEmployeeById(employeeId);
	}

	@RequestMapping("employee-list")
	private List<EmployeeModel> getEmployeeList() {
		return service.getAllEmployeeList();
	}

	private EmployeeController() {
		// no-op
	}

}
