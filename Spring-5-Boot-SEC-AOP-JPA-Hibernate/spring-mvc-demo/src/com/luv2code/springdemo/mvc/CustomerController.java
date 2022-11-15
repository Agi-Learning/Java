package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); 

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		// using the data binder I'll register this as a custom editor. So what I'm ding here is, I'm saying for every string class apply the trimmer editor 
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		System.out.println("Last name: |"+ theCustomer.getLastName());
		
		System.out.println("Binding result: "+ theBindingResult);
		
		System.out.println("\n\n\n\n");
		
//		Handling Spring input for integer fields
//		// handling default error code to overwriting the custom fields, You can overwriting the error code, same technique on you own project
//
//		Last name: |sasdasd
//		Binding result: org.springframework.validation.BeanPropertyBindingResult: 1 errors
//		Field error in object 'customer' on field 'freePasses': rejected value [adadsfasdfasdfa]; codes [typeMismatch.customer.freePasses,typeMismatch.freePasses,typeMismatch.java.lang.Integer,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customer.freePasses,freePasses]; arguments []; default message [freePasses]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Integer' for property 'freePasses'; nested exception is java.lang.NumberFormatException: For input string: "adadsfasdfasdfa"]
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}
}
