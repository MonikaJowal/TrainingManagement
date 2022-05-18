package in.hcl.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.hcl.employee_management.domain.Employee;

@Service
public interface EmployeeService {
	public Employee createEmployee (Employee employee);
	public Employee getEmployeeBySocialSecurityNo(Long socialSecurityNo);
	public void deleteEmployeeBySocialSecurityNo(Long socialSecurityNo);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee employee);
	
}