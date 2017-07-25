package com.spring.loader;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.model.EmployeeModel;
import com.spring.repository.IEmployeeRepository;

@Component
public class EmployeeDataLoader {

	@Autowired
	IEmployeeRepository repository;

	@PostConstruct
	public void loadData() {
		List<EmployeeModel> list = Arrays.asList(new EmployeeModel[] { new EmployeeModel("name1", "team1", 101L),
				new EmployeeModel("name2", "team2", 1001L) });

		repository.save(list);
	}
}
