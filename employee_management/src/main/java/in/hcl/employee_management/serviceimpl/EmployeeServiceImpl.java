package in.hcl.employee_management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
	public Employee getEmployeeBySsn(Long ssn) {
		Optional<Employee> employee = employeeRepository.findBySsn(ssn);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new EmployeeNotFoundException("Employee not found with id :" +ssn);
		}
	}

	@Override
	public void deleteEmployeeBySsn(Long ssn) {
		Employee employeedb = employeeRepository.findBySsn(ssn).get();
		 
			employeeRepository.delete(employeedb);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return  employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employee2 = employeeRepository.findBySsn(employee.getSsn());
		if (employee2.isPresent()) {
			Employee updateEmployee = employee2.get();
			updateEmployee.setId(employee.getId());
			updateEmployee.setSsn(employee.getSsn());
			updateEmployee.setEmployeeName(employee.getEmployeeName());
			updateEmployee.setEmployeeDesignation(employee.getEmployeeDesignation());
			updateEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
			updateEmployee.setEmployeePhone(employee.getEmployeePhone());
			updateEmployee.setEmployeeMail(employee.getEmployeeMail());
			return employeeRepository.save(updateEmployee);
			
		} else {
			throw new EmployeeNotFoundException("Employee not found with id : " + employee.getSsn());
		}
		
	}
}
