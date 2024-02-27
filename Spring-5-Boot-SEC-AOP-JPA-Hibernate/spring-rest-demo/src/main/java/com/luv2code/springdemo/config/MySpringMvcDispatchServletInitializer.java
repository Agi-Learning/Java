package com.luv2code.springdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//# Spring REST - Create a Spring REST Controller
//
//## HTTP Overview
//### REST over HTTP
//
//* Most common use of REST is over HTTP
//* Leverage HTTP methods for CRUD operations
//
//HTTP Method               CRUD Operation
//--
//POST             ->       Create a new entity
//GET              ->       Read a list of entities or single entity
//PUT              ->       Update an exisiting entity
//DELETE           ->       Delete an existing entity
//
//### HTTP Message 
//
//Check Tab -> 
//
//* We have this idea of our client application and we also have our server application. The client's going to send over REST request to a server or a CRM REST service.
//* We'll send over this HTTP request message that'll have data going across and then our server can process it and our server will send back an actual response, an HTTP message response.
//
//#### HTTP Request Message
//
//Check Tab -> 
//
//* The actual request message has 3 main parts. It has a request line, header variables, and a message body. 
//
//* Request line: the HTTP command (GET, POST...)
//* Header variables: request metadata (so additional info about this req)
//* Message body: contents of message (actual payload. If you're adding a new entity, then the actual contents of the entity will be in the message body as JSON.)
//
//#### HTTP Response Message
//
//Check Tab ->
//
//* Response message has 3 different areas, also. has a request line, header variables, and a message body.
//
//* Response line: server protocol and status code like 200, 404 or 500.
//* Header Variables: response metadata (This is the actual info about the data, So the content type of the data if it's XML of if it's JSON, the size or length of the data )
//* Message body: contents of message 
//
//##### HTTP Response - Status Codes
//
//* For the HTTP response, you can send back a status code to give info about the status. 
//
//Code Range                     Description
//--
//100 - 199                      Informational
//200 - 299                      Successful
//300 - 399                      Redirection
//400 - 499                      Client error
//500 - 599                      Server error 
//
//### MIME Content Types
//
//* The message format is described by MIME content type ( This is actually message format actully payload, It's described by MIME content type.)
//	* Multipurpose Internet Mail-Extension
//* Basic Syntax: type/sub-type
//* Examples 
//	* text/html, text/plain (You can have a text/html, or a text/plain This is info that's returned back to the client and then the client can render it accordingly or process on it accordingly. Some ex here, if you return back text/html to a web browser, a web browser will render that based on the html tags. You pass back text/plain, the web browser will simply just show you the plain text in the browser.)
//	* application/json, application/xml,... (In particular, for restful clients, you can pass back application/json, so we can tell that client we're returning JSON data for you Or you can have application/xml, saying hey, this content coming back is XML. And again, the client can process on it accordingly.)
//
//### Client Tool
//
//* We need a client tool
//* Send HTTP requests to the REST Web Service / API
//* Plenty of tools available: curl, Postman, etc...
//
//#### Postman
//
//* Postman is a really popular tool that's used for real time projects and there's a screenshot here that says Postman makes API development simple. 
//
//## Install a REST Client
//## Creating a Spring REST Controller - Overview
//
//### Spring REST Support
//
//* Spring Web MVC provides support for Spring REST 
//* New annotation @RestController
//	* Extension of @ Controller
//	* Handles REST requests and responses
//* Spring REST will also automatically convert Java POJOs to JSON
//	* As long as the Jackson project is on the classpath or pom.xml
//### Spring REST Hello World
//
//Check Tab ->
//
//* We'll also have this REST service, and what we'll do, we'll basically make a request for a /test/hello. This REST service will respond with Hello World.
//
//### Spring REST Controller
//
//```java
//	@RestController
//	@RequestMapping("/test")
//	public class DemoRestController {
//		// Basically at this point we've defined this RESTful endpoint, or this path that we can access RESTful end point by simply going to /test/hello.
//		@GetMapping("hello")
//		public String sayHello(){
//			return "Hello World!";
//		}
//	}
//```
//
//### Testing with REST Client - Postman
//
//* We simply go to localhost:8080 the name of our app string-rest-demo/test/hello, So that'll access that REST endpoint, and so at the bottom we'll actually get the response, Hello World. 
//
//### Testing with REST Client - Web Browser
//
//* In the web browser you simply drop in the URL here, /test/hello and it'll return the response here, Hello World. 
//
//### Web Browser VS Postman
//
//* For simple REST testing for GET requests 
//	* Web Browser and Postman are similar
//* However, for advanced REST testing: POST, PUT etc ...
//	* Postman has much better support 
//	* POSTing JSON data, setting content type 
//	* Passing HTTP request headers, authentication etc...
//
//
//## REST Controller Demo - Set Up Maven Project
//
//### Development Process
//
//1. Add Maven dependency for Spring MVC and Jackson project
//2. Add code for All Java Config:@Configuration
//3. Add code for All Java Config: Servlet Initializer
//4. Create Spring REST Service using @RestController
//
//
//#### Step 1. Add Maven dependency for Spring MVC and Jackson project
//
//```xml
//	<!-- Add Spring MVC and REST support -->
//	<!-- Will load all supporting dependencies: Spring-core logging etc ... -->
//	<dependency>
//		<groupId>org.springframework</groupId>
//		<artifactId>spring-webmvc</artifactId>
//		<version>...</version>
//	</dependency>
//
//	<!-- Add Jackson for JSON converters -->
//	<dependency>
//		<groupId>org.fasterxml.jackson.core</groupId>
//		<artifactId>jackson-databind</artifactId>
//		<version>...</version>
//	</dependency>
//	<!-- Add Servlet Support for Spring's 			  AbstractAnnotationConfigDispatcherServletInitializer -->
//	<dependency>
//		<groupId>javax.servlet</groupId>
//		<artifactId>javax.servlet-api</artifactId>
//		<version>...</version>
//	</dependency>
//
//```
//* So there's nothing special you need to do to add REST support, simply reference spring-webmvc. And now once you access this, then you also load all the supporting dependencies for like spring-core, logging et cetera. 
//* Jackson supports JSON converts for going from JSON to POJO and POJO to Jackson, 
//
//
//#### Step 2. Add code for All Java Config:@Configuration
//
//-> File: DemoAppConfig.java
//```java
//	@Configuration
//	@EnableWebMvc
//	@ComponentScan(basePackages="com.luv2code.springdemo")
//	public class DemoAppConfig {
//		// So here for REST, we don't have to do anything else special here just using this setup for the AppConfiguration. 
//	}
//
//```
//
//##### Web App Initializer
//
//* Spring MVC provides support for web app initialization
//* Makes sure your code is automatically detected
//* Your code is used to initialize the servlet container (U are using Spring MVC app and also REST apps then you'll make use of this )
//```java
//	AbstractAnnotationConfigDispatcherServletInitializer
//```
//* Your TODO list
//	* Extend this abstract base class
//	* Override required methods
//	* Specify servlet mapping and location of your app config
//
//#### Step 3. Add code for All Java Config: Servlet Initializer
//
//-> File: MySpringMvcDispatchServletInitializer.java
//```java
//	import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//	public class MySpringMvcDispacherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//		@Override
//		protected Class <?>[] getRootConfigClasses(){
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		protected Class<?>[] getServletConfigClasses(){
//			return new Class[] { DemoAppConfig.class };
//		}
//
//		@Override
//		protected String[] getServletMapping(){
//			return new String[] { "/" }
//		}
//	}
//```
//
//#### Step 4. Create Spring REST Service using @RestController
//
//```java
//	@RestController
//	@RequestMapping("/test")
//	public class DemoRestController {
//
//		@GetMapping("/hello")
//		public String sayHello(){
//			return "Hello World!";
//		}
//	}
//```
//
//
//
//## REST Controller Demo - Set Up All Java Configuration
//## REST Controller Demo - Creating the REST Controller
//## App Enhancement with Default Page

public class MySpringMvcDispatchServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { DemoAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

}
