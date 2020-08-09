package com.cognizant.pas.consumer.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Business Property Not Found")
public class BusinessPropertyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
