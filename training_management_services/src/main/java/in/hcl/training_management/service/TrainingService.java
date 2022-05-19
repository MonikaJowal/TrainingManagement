package in.hcl.training_management.service;

import java.util.List;
import java.util.Optional;

import in.hcl.training_management.domain.Training;

public interface TrainingService {
	
	public Training saveOrUpdate(Training training);
    public Optional<Training> getTrainingById(Long trainingId);
    public void deleteTrainingById(Long trainingId);
    public List<Training> getAllTraining();
    public Training updateTraining(Training training);

}
