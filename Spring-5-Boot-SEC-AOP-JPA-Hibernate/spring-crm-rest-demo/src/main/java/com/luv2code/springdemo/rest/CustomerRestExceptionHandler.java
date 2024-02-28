package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//# Spring REST - CRUD Database Project - Exception Handling
//
//## Exception Handling - Responses
//
//### Application Interaction
//
//Check Tab ->
//
//* So we've already seen some examples of adding some bad data so we need to add exception handling to make sure that we can give the appropriate response so they can make a get request with some bad data coming in of 999 will make use of these controller advices to kind of pre process, post process. 
//* It'll come into our controller and our controller will check the cutomer to see if it's null. If it's null then we'll actually throw an exception. And then an exception will go back to the controller advice where we'll have these exception handlers and they can handle that exception and remember these are kind of global exception handlers that'll handle that exception and then it'll actually send back an error response as JSON.
//
//### Development Process
//
//1. Create a custom error response class
//2. Create a custom exception class
//3. Update REST service to throw exception if customer not found 
//4. Add an exception handler methods using @ExceptionHandler 
//
//
//
//
//## Exception Handling - Refactor
//## Exception Handling - Annotation
//## Exception Handling - Catch All


@ControllerAdvice
public class CustomerRestExceptionHandler {
	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		// Create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
