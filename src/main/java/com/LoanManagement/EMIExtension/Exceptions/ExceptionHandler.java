package com.LoanManagement.EMIExtension.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = maximumExtensionsLimitReachedExceptions.class)
	public ResponseEntity<APIError> handleMaximunLimitReachedException() {
		logger.error("maximun request limit reached method called");
		APIError error = new APIError(400, "You can post only two request in a year or only three request per loan");
		
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}

}
