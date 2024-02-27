package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//# Spring REST - Exception Handling
//
//## Overview
//
//### Remember our problem?
//
//* Bad student id of 999 ... We found Root cause Index 999 out-of-bounds 
//
//### We really want this ...
//
//* Handle the exception and return error as JSON
//```json
//	{
//		"status": 404,
//		"message": "Student id not found - 999",
//		"timestamp": 152619650271
//	}
//```
//* So we
//
//### Spring REST Exception Handling
//
//Check Tab ->
//
//### Development Process
//
//1. Create a custom error response class
//2. Create a custome exception class
//3. Update REST service to throw exception if student not found 
//4. Add an exception handler method using @ExceptionHandler
//
//#### Step 1. Create a custom error response class
//
//* The custom error response class will be sent back to client as JSON
//* We will define as Java class (POJO). (keep track of status, message and then timestamps)
//* Jackson will handle converting it to JSON ( Converting this POJO over to JSON going back to the client. Now, in this POJO here you can define any custom fields that you want to track. Here I am keep simple status, message, and timestamp, but you can easily extend it, and easily add your own custom fields because that's a regular Java POJO.)
//
//-> File: StudentErrorResponse.java
//```java
//	public class StudentErrorResponse {
//		private int status;
//		private String message;
//		private long timeStamp;
//
//		// constructor
//
//		// getter / setters. 
//		// It's just a regular basic Java POJO or Java class here and again in the bottom right, Jackson will actually convert this POJO over to the appropriate JSON when we send it back and that's it for this example.
//	}
//```
//
//#### Step 2. Create a custome exception class
//
//* The custom student exception will used by our REST service 
//* In our code, if we can't find student, then we'll throw an exception
//* Need to define a custom student exception class
//	* StudentNotFoundException
//
//-> File: StudentNotFoundException.java
//```java
//	public class StudentNotFoundException extends RuntimeException {
//		public StudentNotFoundException(String message){
//			super(message); // Call super class constructor and that's it, so since we're using inheritance,
//			// there's not much code we have to write here for this given exception and this is a very common approach for creating exceptions. 
//		}
//	}
//```
//
//#### Step 3. Update REST service to throw exception 
//
//-> File: StudentRestController.java
//```java
//	@RestController
//	@RequestMapping("/api")
//	public class StudentRestController {
//		@GetMapping("/students/{studentId}")
//		public Student getStudent(@PathVariable int studentId){
//			// check the studentId against list size
//
//			if(( studentId >= theStudents.size()) || (studentId < 0)){
//				throw new StudentNotFoundException("Student id not found - "+ studentId);
//			}
//
//			return theStudents.get(studentId);
//		}
//	}
//```
//
//#### Step 4. Add an exception handler method using @ExceptionHandler
//
//* Define exception handler method(s) with @ExceptionHandler annotation
//* Exception handler will return a ResponseEntity
//* ResponseEntity is a wrapper for the HTTP response object
//* ResponseEntity provides fine-grained control to specify: 
//	* HTTP status code, HTTP headers and Response body
//
//-> File: StudentRestController.java
//```java
//	@RestController
//	@RequestMapping("/api")
//	public class StudentRestController {
//
//		...
//		// 1. Exception Handler method 
//		// 2. Type of the response body (So we have response entity and we say in brackets student error response, so that's the type of data we're going to pass back in the response body.)
//		// 3. Exception type to handle/catch (So here I'll have student not found exceptions. So any student not found exceptions that are thrown, this actual handler method will catch it and then work on it accordingly.)
//
//		@ExceptionHandler/**1.*/
//		public ResponseEntity<StudentErrorResponse/**2.*/> handleException(StudentNotFoundException/**3.*/ exc){
//			// Custom POJO 
//			StudentErrorResponse error = new StudentErrorResponse();
//			
//			error.setStatus(HttpStatus.NOT_FOUND.value());
//			error.setMessage(exc.getMessage());
//			error.setTimeStamp(System.currentTimeMillis());
//			// a system.currentTimeMillis() to give us the current time stamp. So that's the basic piece here as far as creating that student error response and then loading it with the appropriate data.
//
//			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//		}
//	}
//```
//
//
//## Create Custom Error Response and Exception
//## Update REST Service to throw Exception
//## Add Exception Handler with @ExceptionHandler
//## Test the App
//
// -> "http://localhost:8080/spring-rest-demo/api/students/sdsadf"
//
//* When you add an exception handling it didn't cover all of the edge cases, But you see this ugliy, give use code information 
//* The server cannot or will not process the request, "It's the malformed request syntax, right"
//
//-> "WARNING: Failed to bind request element:" -> "org.springframework.web.method.annotation.MethodArgumentTypeMismatchException:" 
//
//-> "Failed to convert value of type 'java.lang.String' to required type 'int';" -> you can't really convert that to an integer. Going even further, the nested exception is " java.lang.NumberFormatException" The input string or that "asdfas" whatever, you can't convert that to an int. That all makes sense, ritht, but we didn't give a good JSON error response, So we'll need to modify our code to handle for these edge cases or setup a generic exception handler, so for any error that happens, we can catch it, and then send back that response as JSON not ugly HTML page.
// 
//## Adding Generic Exception Handler
//## Global Exception Handling Overview
//
//### Its works, but ...
//
//* Exception handler code is only for the specific REST controller 
//* Can't be reused by other controller:-(Large projects will have multiple controllers)
//* We need global exception handlers
//	* Promotes reuse
//	* Centralizes exception handling
//
//### Spring @ControllerAdvice
//
//* @ControllerAdvice is similar to an interceptor / filter
//* Pre-process requests to controllers
//* Post-process responses to handle exceptions
//* Perfect for global exception handling
//
//(@ControllerAdvice this is actually real-time use of AOP, or aspect-oriented programming. So if you remember from the AOP days, we had the ideas of like a before advice, an after advice, and so on.)
//
//#### Spring REST Exception Handling AOP
//
//-> Check Tab
//
//* So Now, with this Spring REST exception handling, with this advice, or the @ControllerAdvice we have our REST client, our REST service. 
//* We make a request across to the actual service, then we'll have this controller advice, to kind of pre-process the request, and then the REST service will execute, 
//* If there's something wrong will throw an exception, and now instead of the exception being in the REST service, the exception handlers going to be moved out and placed in the controller advice. So, this will give us support for global exception handling. 
//* So no need to write all exception handling in each REST service. We can place it in one global location to handle all of those requests, and we can do all of that thanks to this controller advice. 
//
//### Development Process
//
//1. Create new @ControllerAdvice
//2. Refactor REST service ... remove exception handling code 
//3. Add exception handling code to @ControllerAdvice
//
//#### Step 1. Create new @ControllerAdvice
//
//-> File: StudentREstExceptionHandler.java
//```java
//	@ControllerAdvice
//	public class StudentRestExceptionHandler {
//		...
//	}
//```
//
//#### Step 2. Refactor REST service ... remove exception handling code 
//
//-> File: StudentRestController.java
//```java
//	@RestController
//	@RequestMapping("/api")
//	public class StudentRestController {
//		@ExceptionHandler
//		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//			StudentErrorResponse error = new StudentErrorResponse();
//			error.setStatus(HttpStatus.BAD_REQUEST.value()); 
//			error.setMessage(exc.getMessage());
//			error.setTimeStamp(System.currentTimeMillis());
//			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//		}
//	}
//```
//
//#### Step 3. Add exception handling code to @ControllerAdvice
//
//-> File: StudentREstExceptionHandler.java
//```java
//	@ControllerAdvice
//	public class StudentRestExceptionHandler {
//		// Same code as before
//		@ExceptionHandler
//		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//			StudentErrorResponse error = new StudentErrorResponse();
//			error.setStatus(HttpStatus.BAD_REQUEST.value()); 
//			error.setMessage(exc.getMessage());
//			error.setTimeStamp(System.currentTimeMillis());
//			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//		}
//	}
//```
//
//
//## Global Exception Handling with @ControllerAdvice
//



@ControllerAdvice
public class StudentRestExceptionHandler {
	// Same code as before
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}