package co.edu.unbosque.electroshopv1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class CardNotValidException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CardNotValidException() {
		super();
	}
	
	public CardNotValidException(String message) {
		super(message);
	}
}
