package in.hcl.employee_management.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String employeeName;
	private Long socialSecurityNo;
	private String employeeDesignation;
	private String employeeDepartment;
	private String employeePhone;
	private String employeeMail;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String employeeName, Long socialSecurityNo, String employeeDesignation,
			String employeeDepartment, String employeePhone, String employeeMail) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.socialSecurityNo = socialSecurityNo;
		this.employeeDesignation = employeeDesignation;
		this.employeeDepartment = employeeDepartment;
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

	public Long getSocialSecurityNo() {
		return socialSecurityNo;
	}

	public void setSocialSecurityNo(Long socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}


	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}


	public String getemployeeDepartment() {
		return employeeDepartment;
	}


	public void setemployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
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