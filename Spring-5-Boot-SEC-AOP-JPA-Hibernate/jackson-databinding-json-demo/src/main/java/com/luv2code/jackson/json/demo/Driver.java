package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

//# Spring REST - JSON Data Binding
//
//## Overview
//
//### What is JSON?
//
//* JavaScript Object Notation 
//* Lightweight data format for storing and exchanging data ... plain text 
//* Language independent ... not just for JavaScript
//* Can use with any programming language: Java, C#, Python etc...
//
//### Simple JSON Example
//
//```json
//	{
//		"id": 14,
//		"firstName": "Mario",
//		"lastName": "Rossi",
//		"active": true,
//		"courses": null
//	}
//```
//
//* Curley braces define objects in JSON
//* Object members are name / value pairs
//	* Delimited by colons
//* Name is always in double-quotes
//
//### JSON Values
//
//* Numbers: no quotes
//* String: in double quotes
//* Boolean: true, false
//* Nested JSON object
//* Array
//* null
//
//### Nested JSON Objects
//```json
//	{
//		"id": 14,
//		"firstName": "Mario",
//		"lastName": "Rossi",
//		"active": true,
//		"courses": null,
//		"address": {
//			"street": "100 Main St",
//			"city": "Philadelphia",
//			"state": "Pennsylvania",
//			"zip": "19103",
//			"country": "USA"
//		}
//	}
//```
//### JSON Arrays
//
//```json
//	{
//		"id": 14,
//		"firstName": "Mario",
//		"lastName": "Rossi",
//		"active": true,
//		"language": [
//			"Java",
//			"C#",
//			"Python",
//			"Javascript"
//		]
//	}
//```
//* So in JSON you make use of arrays with a square bracket and simply give a comma delimited list of items here.
//
//
//## Data Binding with Jackson
//
//### Java JSON Data Binding
//
//Check Tab ->
//
//* Data binding is the process of converting JSON data to a Java POJO ( So we can use data binding to convert from JSON over to a Java POJO, so it'll read the contents of that JSON stream or file and then populate the Java Object with that given data. or you can go the other way You can start with a Java POJO and then send it down to an actual JSON stream or JSON file. Now this whole process is called data binding. other terms used online such as mapping, serialization, deserialization, marshaling, unmarshaling, it's pretty much all the same thing, it's just basically converting from one format to another.)
//
//### JSON Data Binding with Jackson
//
//* Spring uses the Jackson Project behind the scenes, 
//* Jackson handles data binding between JSON and Java POJO
//* Details on Jackson Project:
//	"https://github.com/FasterSXML/jackson-databind"
//Support for data bind in XML/JSON and so on. So it's very popular project So if you do any type of JSON development in the Java world or any REST development, It's very good chance you're going to run across the Jackson Project.
//
//#### Jackson Data Binding
//
//* Jackson Data Binding API
//	* Package: com.fasterxml.jackson.databind
//* Maven Dependency
//```xml
//	<dependency>
//		<groupId>com.fasterxml.jackson.core</groupId>
//		<artifactId>jackson-databind</artifactId>
//		<version>2.9.0</version>
//	</dependency>
//```
//* By default, Jackson will call appropriate getter/setter method (handle json to pojo, when you go from POJO to JSON it'll call the getter methods,)
//
//##### JSON to Java POJO
//
//* Convert JSON to Java POJO ... call setter methods on POJO
//
//Check Tab->
//
//So basically using jackson call the setter methods on your POJO. So again, going from JSON to Java POJO, they're going to call the setter methods, So they'll call set ID, set first name, setlastName, set active, based on whatever values that you have here in the JSON. And so Jackson will actually do all of this work for your behind the scenes once we get everything set up.
//
//```json
//	{
//		"id": 14,
//		"firstName": "Mario",
//		"lastName": "Rossi",
//		"active": true,
//	}
//```
//
//```java
//	public class Student {
//		private int id;
//		private String firstName;
//		private String lastName;
//		private boolean active;
//
//		public void setId(int id){
//			this.id = id;
//		}
//		// Jackson will do this work for you
//		// Note: Jackson calls the setXXX methods, It does NOT access internal private fields directly
//		public void setFirstName(String firstName){
//			this.firstName = firstName;
//		}
//		public void setLastName(String firstName){
//			this.lastName = lastName;
//		}
//		public void setFirstName(String firstName){
//			this.firstName = firstName;
//		}
//	}
//```
//
//```java
//	import java.io.File;
//	import com.fasterxml.jackson.databind.ObjectMappter;
//
//	public class Driver {
//		public static void main(String[] args) throws Exception {
//			// create object mapper
//			ObjectMapper mapper = new ObjectMapper();
//
//			//read JSON from file and map or convert it to the Java POJO.
//			// 1. Read data from this file
//			// 2. Create an instance of this class and papulate it.
//			// populate the data of the setter methods. Jackson does all of the work for you! So once it done return the object over on the left hand side Student, myStudent  
//			Student myStudent = mapper.readValue(new File("data/sample.json"), Student.class);
//			// also print individual items
//			System.out.println("First name = "+ myStudent.getFirstName());
//			System.out.println("Last name = "+ myStudent.getLastName());
//			// Jackson doing all the heavy lifting for you in the backgroud and handling all the data binding for you application.
//		}
//	}
//```
//
//##### Java POJO to JSON
//
//* Now, let's go the Other direction
//* Convert Java POJO to JSON ... call getter methods on POJO
//
//Check Tab ->
//
//Again, Jackson is called the appropriate getter methods on your POJO and then Jackson will handle getting this data sent out accordingly to a JSON string either to just a memory or to a given file.
//
//```java
//	// create object mapper
//	ObjectMapper mapper = new ObjectMapper();
//
//	// read JSON from file and map/convert to Java POJO
//	Student myStudent = mapper.readValue(new File("data/sample.json"), Student.class);
//
//	// now write JSON to output file
//	mapper.enable(SerializationFeature.INDENT_OUTPUT);
//	// Now basically all these does pretty printing of the JSON just so it looks nice and pretty when it goes out to the actual file and then I say mapper.writeValue and then I give it the actual output file to write to, I'll call it data/output.json and then I give the actual POJO
//	mapper.writeValue(new File("data/output.json"), myStudent);
//```
//
//### Spring and Jackson Support 
//
//* When building Spring REST applications
//* Spring will automatically handle Jackson Integration
//* JSON data being passed to REST controller is converted to POJO
//* Java object being returned from REST controller is converted to JSON
//
//## Jackson Demo - Set up Maven Project
//
//### Development Process
//
//1. Download and import Maven starter files
//2. Add Maven dependency for Jackson project
//3. Create Student POJO Java class 
//4. Create main Driver App
//
//
//## Jackson Demo - Processing JSON
//## Jackson Demo - Nested Objects and Arrays
//## Jackson Demo - Display Nested and Arrays
//## Jackson Demo - Ignore Properties
//
//* If JSON has property you don't care about ... Wouldn't it be great to ignore it? 
//
//### USE Case
//* A new property is added to JSON, Our code is not aware of it... Cause and exception like we saw in previous videos. Let's modify our code to "ignore unknown properties"


public class Driver {

	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO:
			// data/sample-lite.json
			Student myStudent = mapper.readValue(
					new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First name = "+ myStudent.getFirstName());
			System.out.println("Last name = "+ myStudent.getLastName());
			
			// print out address: street and city
			Address tempAddress = myStudent.getAddress();
			
			System.out.println("Street = "+ tempAddress.getStreet());
			System.out.println("City = "+ tempAddress.getCity());
			
			// print out languages
			
			for (String tempLang: myStudent.getLanguages()) {
				System.out.println(tempLang);
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
