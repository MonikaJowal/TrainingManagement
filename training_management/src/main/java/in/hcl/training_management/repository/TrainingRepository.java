package in.hcl.training_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.hcl.training_management.domain.Training;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {
	
	Training findTrainingByBatchno(String batchno);
	Iterable<Training> findAll();

	
	
}
