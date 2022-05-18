package in.hcl.training_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.hcl.training_management.domain.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
	

	
	
}
