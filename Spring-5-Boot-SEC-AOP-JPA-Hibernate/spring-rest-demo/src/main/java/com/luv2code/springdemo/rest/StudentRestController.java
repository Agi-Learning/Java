package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
		return theStudents;
	}
}
