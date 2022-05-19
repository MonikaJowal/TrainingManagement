package in.hcl.training_registration.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.hcl.training_registration.domain.Employee;
import in.hcl.training_registration.domain.Schedule;
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
	@Autowired
	private RestTemplate restTemplate;
	@PostMapping("")
	public ResponseEntity<?>  nominateEmployee(@Valid @RequestBody TrainingRegistration trainingRegistration,BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		TrainingRegistration register  = trainingRegistrationService.saveOrUpdate(trainingRegistration);
		return new ResponseEntity<TrainingRegistration>(register,HttpStatus.CREATED);
	}
	
	@GetMapping("/allregistrations")
	public Iterable<TrainingRegistration> getAllRegistrations(){
		return trainingRegistrationService.findAllTrainingRegistration();
	}	
	
	@DeleteMapping("/{trainingRegistrationId}")
	public ResponseEntity<?> deleteRegistrationById(@PathVariable Long trainingRegistrationId){
		trainingRegistrationService.deleteTrainingRegistrationById(trainingRegistrationId);
		return new ResponseEntity<String>("Trining Registration with Id: "+trainingRegistrationId+" Deleted Succesfully!", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTrainingRegistrationById(@PathVariable Long id){
		TrainingRegistration  trainingRegistration =  trainingRegistrationService.findTrainingRegistrationById(id).get();
		List<Schedule> schedule = restTemplate.getForObject("http://schedule-service//api/schedules/all", List.class);
		List<Employee> employee = restTemplate.getForObject("http://employee-service//api/employees/all", List.class);
		//long scheduleId = restTemplate.getForObject("http://schedule-service//api/schedules/", long.class);
		trainingRegistration.setSchedule(schedule);
		trainingRegistration.setEmployees(employee);
		return new ResponseEntity<TrainingRegistration>(trainingRegistration, HttpStatus.OK);
}
	@GetMapping("/{nominatedFor}/{allottedBatch}")
	public ResponseEntity<?> getAllFullStackNominatedEmployees(@PathVariable String nominatedFor,@PathVariable String allottedBatch){
		List<TrainingRegistration> emps = trainingRegistrationService.findEmployeeByNominatedForCourse(nominatedFor,allottedBatch);
		return new ResponseEntity<List<TrainingRegistration>>(emps,HttpStatus.OK);
	}
	
	
}