package in.hcl.training_registration.repository;


import org.springframework.data.repository.CrudRepository;

import in.hcl.training_registration.domain.TrainingRegistration;

public interface TrainingRegistrationRepository extends CrudRepository<TrainingRegistration, Long> {
	
	TrainingRegistration findRegistrationByEmployeeId(String employeeId);
	
   
	
	//Iterable<TrainingRegistration> findAll();

}