package in.hcl.training_registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import in.hcl.training_registration.domain.TrainingRegistration;

public interface TrainingRegistrationRepository extends CrudRepository<TrainingRegistration, Long>,JpaRepository<TrainingRegistration, Long> {

}