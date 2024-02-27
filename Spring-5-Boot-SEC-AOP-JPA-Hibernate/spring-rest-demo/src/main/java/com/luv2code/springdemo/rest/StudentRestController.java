package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

//# Spring REST - Retrieve POJOs as JSON
//
//## Retrieve POJOs as JSON - Overview
//
//### Create a New Service
//
//* Return a list of students 
//* GET  /api/students Return a list of students -> (Basically we'll send over a get request to /api/students, and this is going it return a list of students for us.)
//
//### Spring REST Service
//
//Check Tab -> 
//
//* We'll access this request mapping /api/students making a get request, and then this will return a list of students as JSON. And then, We'll actually write the code for the service, and we'll do this over the next set of videos.
//
//### Convert Java POJO to JSON
//
//* Our REST Service will return List<Student> (because our REST Service is going it return a list of Student objects)
//* Need to convert List<Student> to JSON
//* Jackson can help us out with this...
//
//### Spring and Jackson Support
//
//* Spring will automatically handle Jackson integration
//* As long as the Jackson project is on the classpath or pom.xml
//* JSON data being passed to REST controller is converted to Java POJO
//* Java POJO being returned from REST controller is converted to JSON 
//
//####  Student POJO (class)
//
//* So, in this ex here we're going it have this POJO or class called Student, we'll have some very basic fields firstName and lastName, and the appropriate setters,  
//* We'll actually call the getter methods, and remember, Jackson's going it do all of this work for us behind the scenes. 
//
//##### Behind the Scenes
//
// -> Check Tab
//
//* So Spring REST and Jackson's going it work together. Any request coming in if there're any JSON data though converted to POJOs, but in this case we're just simply going to that endpoint. Well, on our REST service we'll create a list of objects, or a list of students, and we'll return those items so then Jackson will actually handle converting that list of students to the JSON array. so remember, Jackson can handles the conversions of JSON to POJOs, and POJOs to JSON. So we'll call the appropriate methods and so on, and then we'll send back a JSON array based on that data that we passed to it. 
//
//### Development Process
//
//1. Create Java POJO class for Student
//2. Create Spring REST Service using @RestController
//
//
//#### Step 1. Create Java POJO class for Student
//
//* Same like before Student.js
//
//#### Step 2. Create Spring REST Service using @RestController
//
//```java
//	@RestController
//	@RequestMapping("/api")
//	public class StudentRestController{
//		// define endpoint for "/students" - return list of students
//
//		@GetMapping("/students")
//		public List<Student> getStudents(){
//			List<Student> theStudents = new ArrayList<>();
//			theStudents.add(new Student("Poornima", "Patel"));
//			theStudents.add(new Student("Mario", "Rossi"));
//			theStudents.add(new Student("Mary", "Smith"));
//			// Jackson will convert List<Student> to JSON array as it goes back to the actual REST Client. And again, it all happens in the background.
//			return theStudents;
//		}
//	}
//```
//
//
//
//## Retrieve POJOs as JSON - Create POJO
//## Retrieve POJOs as JSON - Create REST Controller
//## Retrieve POJOs as JSON - Test REST Controller



@RestController
@RequestMapping("/api")
public class StudentRestController{
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data ... only once!
	
	@PostConstruct
	public void loadData() {
		// Only load students data at once @ PostConstruct annotation
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
//	# Spring REST - Using @PathVariable for REST Endpoints
//
//	## Overview
//
//	* Retrieve a single student by id 
//
//	* GET  /api/students/{studentId}   ->   Retrieve a single student (So we'll make a GET request to /api/students/studentID and this will retrieve a single student. Now, the studentId in curly braces here, this is known as a path variable, such that when we actually access it via our REST client, So we could say /api/student/0 to give us the student with id 0,1,2,3 and so on. So basically, a way of parameterizing your path or the endpoint to actually accept data. )
//
//	### Development Process
//	1. Add request mapping to Spring REST Service
//		* Bind path variable to method parameter using @PathVariable 
//
//	#### Step 1: Add Request Mapping
//
//	-> File: StudentRestController.java
//	```java
//		@RestController
//		@RequestMapping("/api")
//		public class StudentRestController {
//			// define endpoint for "/students/{studentId}" - return student at index
//
//			@GetMapping("/students/{studentId}")
//			public Student getStudent(@PathVariable int studentId){
//				// This is actually Bind the path variable (by default, must match )
//				List<Student> theStudents = new ArrayList<>();
//
//				// populate theStudents
//				...
//
//				return theStudents.get(studentId);
//			}
//		}
//	```
//
//
//	## Refactoring Code
//	## Code @PathVariable
	
	
	// define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		// Just index into the list ... keep it simple for now 
		
		return theStudents.get(studentId);
	}
}















