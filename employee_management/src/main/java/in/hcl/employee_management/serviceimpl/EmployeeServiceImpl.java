package in.hcl.employee_management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.employee_management.domain.Employee;
import in.hcl.employee_management.exception.EmployeeNotFoundException;
import in.hcl.employee_management.repository.EmployeeRepository;
import in.hcl.employee_management.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeBySocialSecurityNo(Long socialSecurityNo) {
		Optional<Employee> employee = employeeRepository.findBySocialSecurityNo(socialSecurityNo);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new EmployeeNotFoundException("Employee not found with id :" +socialSecurityNo);
		}
	}

	@Override
	public void deleteEmployeeBySocialSecurityNo(Long socialSecurityNo) {
		Employee empdb = employeeRepository.findBySocialSecurityNo(socialSecurityNo).get();
		 
			employeeRepository.delete(empdb);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return  employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employee2 = employeeRepository.findById(employee.getId());
		if (employee2.isPresent()) {
			Employee updateEmployee = employee2.get();
			updateEmployee.setId(employee.getId());
			updateEmployee.setSocialSecurityNo(employee.getSocialSecurityNo());
			updateEmployee.setEmployeeName(employee.getEmployeeName());
			updateEmployee.setEmployeeDesignation(employee.getEmployeeDesignation());
			updateEmployee.setemployeeDepartment(employee.getemployeeDepartment());
			updateEmployee.setEmployeePhone(employee.getEmployeePhone());
			updateEmployee.setEmployeeMail(employee.getEmployeeMail());
			return employeeRepository.save(updateEmployee);
			
		} else {
			throw new EmployeeNotFoundException("Employee not found with id : " + employee.getSocialSecurityNo());
		}
		
	}
}
