package in.hcl.employee_management.serviceimpl;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import in.hcl.employee_management.domain.Employee;
import in.hcl.employee_management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


	//list of employees
	
	List<Employee> list = Arrays.asList(
			new Employee(7532L,"Naveen","SoftwareEngineer","Development","9578965","naveen@hcl.com"),
			new Employee(6545L,"kumar","TestEngineer","Development","4857278","kumar@hcl.com")
			);
		
	
	@Override
	public Employee getEmployee(Long id) {
		return list.stream().filter(employee->employee.getId().equals(id)).findAny().orElse(null);
	}
	
}
