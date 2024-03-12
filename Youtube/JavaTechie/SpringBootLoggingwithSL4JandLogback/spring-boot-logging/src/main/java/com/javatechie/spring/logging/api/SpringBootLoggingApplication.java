package com.javatechie.spring.logging.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLoggingApplication {
	Logger log = LoggerFactory.getLogger(SpringBootLoggingApplication.class);

	// Effort to implement the login. Now we will our customize our login mechanism
	// using the log pair Show and I'll show you here for error there. I want to
	// generate the separate lock file. And for like, if there is no error and we
	// are getting the 20 status code, like the response is perfect, then I want to
	// generate the one more log file So create a xml file here.
	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {
		log.debug("Request {}", name);
		if (name.equalsIgnoreCase("test")) {
			throw new RuntimeException("Opps Exception raised....");
		}
		String response = "Hi " + name + " Welcome to Java Techie";
		log.debug("Response {}", response);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingApplication.class, args);
	}
}
