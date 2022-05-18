package in.hcl.employee_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.employee_management.domain.Employee;
import in.hcl.employee_management.service.EmployeeService;
import in.hcl.employee_management.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Employee emp1 = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(emp1, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getEmployee/{socialSecurityNo}")
	public Employee getEmployeeBySocialSecurityNo(@PathVariable Long socialSecurityNo) {
		return employeeService.getEmployeeBySocialSecurityNo(socialSecurityNo);
	}
	
	
	@PutMapping("/updateEmployee")
	public Employee UpdateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getEmployeeList() {
		return employeeService.getAllEmployee();
	}
	
	@DeleteMapping("/delete/{socialSecurityNo}")
	public void deleteEmployeeBySocialSecurityNo(@PathVariable Long socialSecurityNo) {
		employeeService.deleteEmployeeBySocialSecurityNo(socialSecurityNo);
	}
	
}
	
	
	
