package in.hcl.training_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TrainingNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	public TrainingNotFoundException() {
	super();
	}
	public TrainingNotFoundException(String errMsg) {
	super(errMsg);
	}


	
}
