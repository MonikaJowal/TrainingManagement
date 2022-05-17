package in.hcl.training_registration.service;

import java.util.List;

import in.hcl.training_registration.domain.TrainingRegistration;

public interface TrainingRegistrationService {
	
	public  TrainingRegistration  saveOrUpdate(TrainingRegistration trainingRegistration);	
	
	public TrainingRegistration findTrainingRegistrationByEmployeeId(String empId);
	
	public Iterable<TrainingRegistration> findAllTrainingRegistration();
	

	List<TrainingRegistration> findEmployeeByNominatedForFullStack(String nominatedFor, String allottedBatch);
	

}