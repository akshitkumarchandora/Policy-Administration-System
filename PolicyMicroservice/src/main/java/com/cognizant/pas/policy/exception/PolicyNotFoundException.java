package com.cognizant.pas.policy.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Policy Not Found")
public class PolicyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PolicyNotFoundException(String message) {
		super(message);
	}

}
