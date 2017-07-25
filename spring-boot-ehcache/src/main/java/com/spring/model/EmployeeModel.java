package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeModel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4978998945548138824L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String teamName;
	private Long sal;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * @return the sal
	 */
	public Long getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(Long sal) {
		this.sal = sal;
	}
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeModel(String name, String teamName, Long sal) {
		super();
		this.name = name;
		this.teamName = teamName;
		this.sal = sal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", name=" + name + ", teamName=" + teamName + ", sal=" + sal + "]";
	}
	
	
	
	
}
