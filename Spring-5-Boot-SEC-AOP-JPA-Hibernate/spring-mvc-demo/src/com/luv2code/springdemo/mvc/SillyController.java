package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//24. Add Controller @RequestMapping

//* Serves as parent mapping for controller
//* All request mappings on methods in the controller are relative
//* Similar to folder directory structures
//
//@RequestMapping("/funny")
//public class FunnyController {
//	@RequestMapping("/showForm")
//	public String showForm(){
//		...
//	}
//
//	@RequestMapping("/processForm")
//	public String process(HttpServletRequest request, Model model){
//
//	}
//}
//
//controller mapping -> funny
//request mapping -> showForm
//And also a great technique for resolving any problems or conflicts that you may have with other reques mappings 
@Controller
public class SillyController {
	@RequestMapping("/showForm")
	public String showForm(){
		return "silly";
	}

	@RequestMapping("/processForm")
	public String process(HttpServletRequest request, Model model){
		return null;
	}
}
//How does "processForm" work for "/hello"
//
//Ans: You can use "processForm" because it is a relative path to the controller "/hello" request mapping. Here is how it works
//
//1. When you wisht to view the form,s the HTML link points to "hello/showForm". This calls the controller and it displays the form.
//
//2. At the point the browser URL/path is: /spring-mvc-demo/hello
//
//3. The HTML form uses "processForm" for the form action. Notice that it does not have a forward slash, as a result, this will be relative to the current browser URL.