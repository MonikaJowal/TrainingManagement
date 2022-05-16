package in.hcl.schedule_management.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.schedule_management.domain.Schedule;
import in.hcl.schedule_management.repository.ScheduleRepository;
import in.hcl.schedule_management.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	@Override
	public Schedule createSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public Schedule getScheduleById(Long employeeid) {
		// TODO Auto-generated method stub
		return scheduleRepository.getById(employeeid);
	}

	@Override
	public void deleteScheduleById(Long employeeid) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public List<Schedule> getAllSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule updateSchedule(Schedule schedule, Long employeeid) {
		// TODO Auto-generated method stub
		return null;
	}


}
