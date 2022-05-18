package in.hcl.training_management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.training_management.domain.Training;
import in.hcl.training_management.exception.TrainingNotFoundException;
import in.hcl.training_management.repository.TrainingRepository;
import in.hcl.training_management.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {
	@Autowired
	private TrainingRepository trainingRepository;

	@Override
	public Training saveOrUpdate(Training training) {
	        return trainingRepository.save(training);
	}

	@Override
	public Optional<Training> getTrainingById(Long trainingId) {
		Optional<Training> training = trainingRepository.findById(trainingId);
		if (training==null) {
		throw new TrainingNotFoundException("Training id:"+ trainingId+"Dose not exists");
		}
		return training;
	}

	@Override
	public List<Training> getAllTraining() {
		return trainingRepository.findAll();
	}

	@Override
	public Training updateTraining(Training training) {
		Optional<Training> training1 = trainingRepository.findById(training.getTrainingId());
		if (training1.isPresent()) {
			Training updatedTraining = training1.get();
			updatedTraining.setTrainingId(training.getTrainingId());
			updatedTraining.setName(training.getName());
			updatedTraining.setContact(training.getContact());
			updatedTraining.setEmail(training.getEmail());
			updatedTraining.setProgrameName(training.getProgrameName());
			updatedTraining.setTrainerName(training.getTrainerName());
			updatedTraining.setTrainingtype(training.getTrainingtype());
			updatedTraining.setNoOfTraining(training.getNoOfTraining());
			updatedTraining.setTrainingStatus(training.getTrainingStatus());
			updatedTraining.setBatchNo(training.getBatchNo());
			updatedTraining.setAveragerating(training.getAveragerating());
			updatedTraining.setBudget(training.getBudget());
			return trainingRepository.save(updatedTraining);
		} else {
			throw new TrainingNotFoundException("Schedule not found with id : " + training.getTrainingId());
		}
	}

	@Override
	public void deleteTrainingById(Long trainingId) {
		Optional<Training> training = trainingRepository.findById(trainingId);
		if(training.isPresent()) {
			trainingRepository.delete(training.get());
		} else {
			throw new TrainingNotFoundException("Training not found with id : " + trainingId);
		}
		
	}

}

