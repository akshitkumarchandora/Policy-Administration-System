package com.cognizant.pas.policy.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ConsumerBusiness Not Found")
public class ConsumerBusinessNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ConsumerBusinessNotFoundException(String message) {
		super(message);
	}

}
