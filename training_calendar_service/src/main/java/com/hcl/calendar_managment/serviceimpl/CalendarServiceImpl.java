package com.hcl.calendar_managment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.calendar_managment.domain.Calendar;
import com.hcl.calendar_managment.repository.CalendarRepository;
import com.hcl.calendar_managment.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarRepository calendarRepository;

	@Override
	public Calendar createCalendar(Calendar calendar) {
		return calendarRepository.save(calendar);
	}

	@Override
	public Calendar getCalendarById(Long calendarId) {
		return calendarRepository.findById(calendarId).get();
	}

	@Override
	public void deleteCalendarById(Long calendarid) {
		calendarRepository.deleteById(calendarid);
		
	}

	@Override
	public List<Calendar> getAllCalendar() {
		return calendarRepository.findAll();
	}

	@Override
	public Calendar updateCalendar(Calendar updatedCalendar, Long calendarId) {
		Calendar calendar2 = calendarRepository.findByCalendarId(calendarId);
		calendar2 = updatedCalendar;
		
		return calendarRepository.save(calendar2);
	}

}
