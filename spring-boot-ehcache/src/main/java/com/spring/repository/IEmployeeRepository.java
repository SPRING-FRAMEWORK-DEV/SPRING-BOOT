package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.EmployeeModel;

public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long> {

	EmployeeModel findByName(String name);

}
