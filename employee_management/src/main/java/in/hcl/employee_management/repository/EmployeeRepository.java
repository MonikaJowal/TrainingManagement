package in.hcl.employee_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.hcl.employee_management.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Optional<Employee> findBySocialSecurityNo(Long socialSecurityNo);
	
}
