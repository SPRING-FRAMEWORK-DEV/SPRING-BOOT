package com.ahlo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahlo.exceptions.RecordNotFoundException;
import com.ahlo.model.EmployeeVO;
import com.ahlo.response.ResponseSender;
import com.ahlo.service.employee.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@SuppressWarnings("rawtypes")
	@Autowired
	ResponseSender responseSender;

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/")
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeVO employee) {
		EmployeeVO employeeVO = employeeService.save(employee);
		EmployeeVO[] employeeVOs = new EmployeeVO[] { employeeVO };
		return responseSender.sendResponse(employeeVOs);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {
		EmployeeVO employee = employeeService.findById(id);
		
		if (employee == null) {
			throw new RecordNotFoundException("Invalid employee id : " + id);
		}
		EmployeeVO[] employeeVOs = new EmployeeVO[] { employee };
		return responseSender.sendResponse(employeeVOs);
	}

	@GetMapping(value = "/")
	public ResponseEntity<Object> getEmployees() {

		List<EmployeeVO> employees = employeeService.findAll();
		return responseSender.sendResponse(employees.toArray(new EmployeeVO[employees.size()]));
	}

}
