package in.hcl.training_registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TrainingRegisterIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public TrainingRegisterIdException() {
		super();
	}
	

	public TrainingRegisterIdException(String errMsg) {
		super(errMsg);
	}
	
}