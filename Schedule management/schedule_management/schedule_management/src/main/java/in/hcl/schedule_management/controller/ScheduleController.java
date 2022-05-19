package in.hcl.schedule_management.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.schedule_management.domain.Schedule;
import in.hcl.schedule_management.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private in.hcl.schedule_management.serviceimpl.MapValidationErrorService mapValidationErrorService;

	@PostMapping("/createSchedule")
	public ResponseEntity<?> createNewSchedule(@Valid @RequestBody Schedule schedule, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Schedule schel = scheduleService.createSchedule(schedule);
		return new ResponseEntity<Schedule>(schel, HttpStatus.CREATED);
	}

	@GetMapping("/getSchedule/{scheduleId}")
	public Schedule getScheduleById(@PathVariable("scheduleId") Long scheduleId) {
		return scheduleService.getScheduleById(scheduleId);
	}

	@PutMapping("/updateSchedule")
	public Schedule getUpdatedSchedule(@RequestBody Schedule schedule) {
		return scheduleService.updateSchedule(schedule);
	}

	@GetMapping("/getAllSchedule")
	public List<Schedule> getScheduleList() {
		return scheduleService.getAllSchedule();
	}

	@DeleteMapping("/delete/{scheduleId}")
	public void deleteScheduleById(@PathVariable("scheduleId") Long scheduleId) {
		scheduleService.deleteScheduleById(scheduleId);
	}
}





