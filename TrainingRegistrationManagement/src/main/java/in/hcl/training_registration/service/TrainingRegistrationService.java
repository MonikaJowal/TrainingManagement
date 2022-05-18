package in.hcl.training_registration.service;

import java.util.List;
import java.util.Optional;

import in.hcl.training_registration.domain.TrainingRegistration;

public interface TrainingRegistrationService {
	
public  TrainingRegistration  saveOrUpdate(TrainingRegistration trainingRegistration);	
	
	public Optional<TrainingRegistration> findTrainingRegistrationById(Long trainingResgistrationId);
	
	public Iterable<TrainingRegistration> findAllTrainingRegistration();
	
	public void deleteTrainingRegistrationById(Long id);
	
	List<TrainingRegistration> findEmployeeByNominatedForCourse( String nominatedFor, String allottedBatch);
	
}