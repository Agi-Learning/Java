package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//21. Reading Form Data with Spring MVC
//High Level View
//We're going to prompt the user for their name, they'll hit Submit Query, It'll go through our Spring MVC application, and then we'll show a confirmation page, 
//
//Application Flow
//
//Browser -> Req Mapping(/showForm)-> Hello World Controller -> helloworld-form.jsp
//
//helloworld-form.jsp -> Req Mapping(/processForm)-> Hello World Controller -> helloworld.jsp
//
//browser send to our websites /showForm, This will go to our Hello World controller and the main purpose of this is to simply show the JSP form
//Then once we have the form displays once they enter their information and hit submit, then gonna pass over to this /processForm req mapping. Again go back into a HelloWorld controller, and for that mapping we'll simply pass back a confirmation page. Hello World of Spring, student name, and we simply plug in the student name.
//
//So key here is to one Hello World controller, that's gonna have 2 req mappings. 
//
//Controller Class
//
//@Controller
//public class HelloWorldController {
//	// need a controller method to show the initial HTML form 
//	// Any method name you want
//	@RequestMapping("/showForm")
//	public String showForm(){
//		return "helloworld-form";
//	}
//
//	// need a controller method to process the HTML form
//	@RequestMapping("/processForm")
//	public String processForm(){
//		return "helloworld";
//	}
//}
//
//Development Process
//
//1. Create Controller class
//2. Show HTML form
//	* Create controller method to show HTML Form
//	* Create View Page for HTML form
//
//3. Process HTML Form
//	* Create controller method to process HTML Form
//	* Develop View Page for Confirmation
//
//

@Controller
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}

	
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
}
