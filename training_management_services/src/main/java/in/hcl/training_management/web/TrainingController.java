package in.hcl.training_management.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.training_management.domain.Training;
import in.hcl.training_management.service.TrainingService;
import in.hcl.training_management.serviceimpl.MapValidateErrorService;
@RestController
@RequestMapping("/training")
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
	public Optional<Training> getTrainingById(@PathVariable("trainingId") Long trainingId) {
		return trainingService.getTrainingById(trainingId);
	}
	
	@PutMapping("/updateTraining")
	public Training getUpdatedTraining(@RequestBody Training training) {
		return trainingService.updateTraining(training);
	}
	
	@GetMapping("/getAll")
	public List<Training> getTrainingList() {
		return trainingService.getAllTraining();
	}
	
	@DeleteMapping("/d/{trainingId}")
	public void deleteTrainingById(Long trainingId) {
		trainingService.deleteTrainingById(trainingId);
	}
	
}
