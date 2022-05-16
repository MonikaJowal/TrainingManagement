package in.hcl.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.employee_management.domain.Employee;
import in.hcl.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{employeeId}")
	public Employee getEmployee (@PathVariable ("employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
		
	}
	
	
}
