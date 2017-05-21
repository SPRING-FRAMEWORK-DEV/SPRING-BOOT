package com.spring.model;

public class DepartmentModel {

	private String departmentId;
	private String name;
	private Integer totalEmployee;
	private Integer establishedYear;

	public DepartmentModel(String departmentId, String name, Integer totalEmployee, Integer establishedYear) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.totalEmployee = totalEmployee;
		this.establishedYear = establishedYear;
	}

	public DepartmentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(Integer totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public Integer getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(Integer establishedYear) {
		this.establishedYear = establishedYear;
	}

}
