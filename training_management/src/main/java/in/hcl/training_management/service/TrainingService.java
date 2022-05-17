package in.hcl.training_management.service;

import in.hcl.training_management.domain.Training;

public interface TrainingService {
	
	
	public Training saveOrUpdate(Training training);
	public Training findTrainingByBatchno(String batchno);



	public Iterable<Training> findAllTraining();
//	public void deleteTrainingtByBatchno(String batchno);
	
	

}
