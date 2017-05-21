package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.spring.model.EmployeeModel;

@Service
public class EmployeeService {

	/** employeeDataMap contains employee model data. **/
	private Map<String, EmployeeModel> employeeDataMap = null;

	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
		employeeDataMap = new ConcurrentHashMap<String, EmployeeModel>();
		createEmployeeObjects();
	}

	public EmployeeModel getEmployeeById(String empId) {
		return employeeDataMap.get(empId);
	}

	public List<EmployeeModel> getAllEmployeeList() {
		List<EmployeeModel> dataList = new ArrayList<EmployeeModel>();

		for (Map.Entry<String, EmployeeModel> e : employeeDataMap.entrySet()) {
			dataList.add(e.getValue());
		}
		return dataList;
	}

	private void createEmployeeObjects() {

		EmployeeModel model1 = new EmployeeModel("101", "NAME-1", "CITY-1", 31);
		EmployeeModel model2 = new EmployeeModel("102", "NAME-2", "CITY-2", 32);
		EmployeeModel model3 = new EmployeeModel("103", "NAME-3", "CITY-3", 33);
		EmployeeModel model4 = new EmployeeModel("104", "NAME-4", "CITY-4", 34);
		EmployeeModel model5 = new EmployeeModel("105", "NAME-5", "CITY-5", 35);

		put(model1);
		put(model2);
		put(model3);
		put(model4);
		put(model5);

	}

	private EmployeeModel put(EmployeeModel model) {
		return employeeDataMap.put(model.getEmployeeId(), model);
	}
}
