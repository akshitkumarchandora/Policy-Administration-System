package com.cognizant.pas.policy.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ConsumerPolicy Not Found")
public class ConsumerPolicyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ConsumerPolicyNotFoundException(String message) {
		super(message);
	}

}
