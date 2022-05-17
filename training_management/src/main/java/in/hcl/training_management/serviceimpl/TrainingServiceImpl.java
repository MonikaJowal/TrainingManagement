package in.hcl.training_management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.training_management.domain.Training;
import in.hcl.training_management.exception.TrainingIdException;
import in.hcl.training_management.repository.TrainingRepository;
import in.hcl.training_management.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {
	@Autowired
	private TrainingRepository trainingRepository;

	@Override
	public Training saveOrUpdate(Training training) {
		
	        try {
	            training.setBatchno(training.getBatchno().toUpperCase());
	        return trainingRepository.save  (training);
	    }catch(Exception ex) {
	        throw new TrainingIdException("Training Id:" +training.getBatchno().toUpperCase()+"already exists");
	    }
	         
	}
	@Override
	public Training findTrainingByBatchno(String batchno) {
		Training training = trainingRepository.findTrainingByBatchno(batchno.toUpperCase());
		if (training==null) {
		throw new TrainingIdException("batchno:"+batchno.toUpperCase()+"Dose not exists");
		}
		return training;
	}

	@Override
	public Iterable<Training> findAllTraining() {
		
		return findAllTraining();
	}

//	@Override
//	public void deleteTrainingtByBatchno(String batchno) {
//		Training training =trainingRepository.findTrainingByBatchno(batchno.toUpperCase());
//		if (training==null) {
//			throw new TrainingIdException("batchno:" + batchno.toUpperCase());
//		}
//		trainingRepository.delete(training);
//		}

}

