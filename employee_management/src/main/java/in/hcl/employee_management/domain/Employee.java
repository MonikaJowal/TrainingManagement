package in.hcl.employee_management.domain;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Employee {

	private Long id;
	private String employeeName;
	private String employeeDesignation;
	private String employeeDepartement;
	private String employeePhone;
	private String employeeMail;
	
	
	public Employee(Long id, String employeeName, String employeeDesignation, String employeeDepartement,
			String employeePhone, String employeeMail) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeDepartement = employeeDepartement;
		this.employeePhone = employeePhone;
		this.employeeMail = employeeMail;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeDesignation() {
		return employeeDesignation;
	}


	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}


	public String getEmployeeDepartement() {
		return employeeDepartement;
	}


	public void setEmployeeDepartement(String employeeDepartement) {
		this.employeeDepartement = employeeDepartement;
	}


	public String getEmployeePhone() {
		return employeePhone;
	}


	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}


	public String getEmployeeMail() {
		return employeeMail;
	}


	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}
	
	
	
}