package com.hcl.calendar_managment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class CustomResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectNotFoundException(CalendarNotFoundException ex, WebRequest request ){
		CalendarNotFoundExceptionResponse exceptionResponse = new CalendarNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object> (exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
