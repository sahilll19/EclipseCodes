package com.cg.mts.exception;

public class InvalidIdException extends RuntimeException {
	
	public InvalidIdException() {
		super();
	}
	
	public InvalidIdException(String message) {
		super(message);
		
	}
	
	public InvalidIdException(Throwable cause) {
		super(cause);
	}

}
