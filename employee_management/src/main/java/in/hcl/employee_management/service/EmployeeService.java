package in.hcl.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.hcl.employee_management.domain.Employee;

@Service
public interface EmployeeService {
	public Employee createEmployee (Employee employee);
	public Employee getEmployeeBySsn(Long ssn);
	public void deleteEmployeeBySsn(Long ssn);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee employee);
	
}