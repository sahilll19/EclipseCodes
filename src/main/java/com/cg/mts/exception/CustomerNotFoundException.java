package com.cg.mts.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException() {
		super();
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
