package com.hcl.calendar_managment.serviceimpl;

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
	public Calendar getCalendarById(Long calendarId) {
		Calendar cal = calendarRepository.findById(calendarId).get();
		if(cal != null) {
			return cal;
		} else {
			throw new CalendarNotFoundException("Schedule not found with id : " + calendarId);
		}
	}

	}


