package com.hcl.calendar_managment.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.calendar_managment.domain.Calendar;
import com.hcl.calendar_managment.exception.CalendarNotFoundException;
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
		Optional<Calendar> cal = calendarRepository.findById(calendarId);
		if(cal.isPresent()) {
			return cal.get();
		} else {
			throw new CalendarNotFoundException("Schedule not found with id : " + calendarId);
		}
		 
	}

	@Override
	public List<Calendar> getAllCalendar() {
		return calendarRepository.findAll();
	}

	@Override
	public Calendar updateCalendar(Calendar calendar) {
		Optional<Calendar> calendar2 = calendarRepository.findById(calendar.getCalendarId());
		if (calendar2.isPresent()) {
			Calendar updatedCalendar = calendar2.get();
			updatedCalendar.setCalendarId(calendar.getCalendarId());
			updatedCalendar.setProgrameName(calendar.getProgrameName());
			updatedCalendar.setStartDate(calendar.getStartDate());
			updatedCalendar.setEndDate(calendar.getEndDate());
			return calendarRepository.save(updatedCalendar);
		} else {
			throw new CalendarNotFoundException("Schedule not found with id : " + calendar.getCalendarId());
		}
	}
	@Override
	public void deleteCalendarById(Long calendarid) {
	Calendar calendardb =	calendarRepository.findById(calendarid).get();
	try {
		calendarRepository.delete(calendardb);;
	} catch (CalendarNotFoundException e) {

		throw new CalendarNotFoundException("Schedule not found with id : " + calendarid);}
		
	}
	
	}


