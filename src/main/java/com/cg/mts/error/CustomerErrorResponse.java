package com.cg.mts.error;

import lombok.Data;

//for getters, setters, constructors and toString
@Data
public class CustomerErrorResponse {
	
		private int status;
		private String message;
		private long timestamp;

}
