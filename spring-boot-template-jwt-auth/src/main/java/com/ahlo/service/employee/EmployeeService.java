package com.ahlo.service.employee;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahlo.dao.EmployeeDao;
import com.ahlo.exceptions.DuplicateRecordException;
import com.ahlo.model.EmployeeVO;

@Component
@Transactional
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public EmployeeVO save(EmployeeVO employee) {
		if (employeeDao.findByEmail(employee.getEmail()) != null) {
			throw new DuplicateRecordException("Employee email already exists");
		}
		return employeeDao.save(employee);
	}

	@Override
	public List<EmployeeVO> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeVO findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findOne(id);
	}

}
