package com.ahlo.service.employee;

import java.util.List;

import com.ahlo.model.EmployeeVO;

public interface IEmployeeService {

	EmployeeVO save(EmployeeVO employee);

	List<EmployeeVO> findAll();

	void delete(long id);

	
	EmployeeVO findById(int id);
}
