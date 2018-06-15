package com.ahlo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahlo.model.EmployeeVO;

public interface EmployeeDao extends JpaRepository<EmployeeVO, Integer> {
	EmployeeVO findByEmail(String email);
}
