package in.hcl.training_management.web;

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

import in.hcl.training_management.domain.Training;
import in.hcl.training_management.service.TrainingService;
import in.hcl.training_management.serviceimpl.MapValidateErrorService;
@RestController
@RequestMapping("/trainee")
public class TrainingController {
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private MapValidateErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> createNewTraining(@Valid @RequestBody Training training,BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)return errorMap;
		Training savedTraining = trainingService.saveOrUpdate(training);
		return new ResponseEntity<Training>(savedTraining,HttpStatus.CREATED);
	}
	@GetMapping("/{trainingId}")
	public ResponseEntity<?> getTraineeById(@PathVariable String batchno){
		Training training = trainingService.findTrainingByBatchno(batchno);
		return new ResponseEntity<Training>(training,HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<Training> getAllTraining(){
		return trainingService.findAllTraining();
	}
}
