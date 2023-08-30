package com.app.sathya.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.sathya.customexception.EmployeeNoFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	
	@ExceptionHandler(EmployeeNoFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFound(EmployeeNoFoundException enfe)
	{
		return new ResponseEntity<String>(enfe.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	

}
