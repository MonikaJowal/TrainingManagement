package in.hcl.training_registration.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.training_registration.domain.TrainingRegistration;
import in.hcl.training_registration.service.TrainingRegistrationService;
import in.hcl.training_registration.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/trainingregistration")
public class TrainingRegistrationController {

	@Autowired
    private TrainingRegistrationService trainingRegistrationService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?>  nominateEmployee(@Valid @RequestBody TrainingRegistration trainingRegistration,BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		TrainingRegistration register  = trainingRegistrationService.saveOrUpdate(trainingRegistration);
		return new ResponseEntity<TrainingRegistration>(register,HttpStatus.CREATED);
	}
	
	@GetMapping("/registeredemployees")
	public Iterable<TrainingRegistration> getAllNominatedEmployees(){
		return trainingRegistrationService.findAllTrainingRegistration();
	}	

	@GetMapping("/{nominatedFor}/{allottedBatch}")
	public ResponseEntity<?> getAllFullStackNominatedEmployees(@PathVariable String nominatedFor, @PathVariable String allottedBatch){
		List<TrainingRegistration> emps = trainingRegistrationService.findEmployeeByNominatedForFullStack(nominatedFor,allottedBatch);
		return new ResponseEntity<List<TrainingRegistration>>(emps,HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<?> getTrainingRegistrationByEmployeeId(@PathVariable String employeeId){
		TrainingRegistration  trainingRegistration =  trainingRegistrationService.findTrainingRegistrationByEmployeeId(employeeId);
		return new ResponseEntity<TrainingRegistration>(trainingRegistration, HttpStatus.OK);
}
}