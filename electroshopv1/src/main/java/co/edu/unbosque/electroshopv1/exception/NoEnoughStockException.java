package co.edu.unbosque.electroshopv1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoEnoughStockException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoEnoughStockException() {
		super();
	}
	
	public NoEnoughStockException(String message) {
		super(message);
	}
}
