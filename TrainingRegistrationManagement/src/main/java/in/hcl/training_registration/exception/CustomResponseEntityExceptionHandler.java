package in.hcl.training_registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<Object> handleEmployeeIdException(TrainingRegisterIdException ex, WebRequest request){
		TrainingRegisterIdExceptionResponse  exceptionResponse = new TrainingRegisterIdExceptionResponse(ex.getMessage());

	return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
}
}