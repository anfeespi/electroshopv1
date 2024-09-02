package co.edu.unbosque.electroshopv1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NotCreateException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotCreateException() {
		super();
	}

	public NotCreateException(String message) {
		super(message);
	}

	
}
