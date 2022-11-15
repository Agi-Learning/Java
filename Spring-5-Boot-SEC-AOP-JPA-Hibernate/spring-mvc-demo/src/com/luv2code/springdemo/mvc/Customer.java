package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//26. Spring MVC Form Validation Overview
//The Need for Validation
//Check the user input form for 
//	required fields
//	valid numbers in a range
//	valid format (postal code)
//	custom business rule
//
//Java's Standard Bean Validation API
//	* Java has a standard Bean Validation API
//	* Defines a metadata model and API for entity validation
//	* Not tied to either the web tier or the persistence tier
//	* Available for server-side apps and also client-side JavaFX/Swing apps
//
//Validation Feature
//--------------------
//required
//validate length
//validate numbers
//validate with regular expressions
//custom validation
//
//Validation Annotation
//
//Annotation              Description
//@NotNull                Checks that the annotated value is not null
//@Min					Must be a number >= value
//@Max 					Must be a number <= value
//@size 					Size must match the given size
//@pattern				Must match a regular expression pattern
//@Future / @Past			Date must be in future or past of given date
//others...
//
//Our Road Map
//
//1. set up our development enviroinment
//2. required field
//3. validate number range: min, max
//4. validate using regular exp 
//5. custom validation
//
//Java's Standard Bean Validation API
//
//* Java's standard Bean Validation API (JSR-303)
//* Only a specification ... vendor independent ... portable 
//* BUT we still need an implementation...
//
//So this Hibernate comes into play
//
//The Hibernate Team to the rescue!
//
//* Hibernate started as an ORM project (object relational mapping poject)
//* But in recent years, they have expanded into other areas
//* They have a fully compliant JSR-303 implementation
//	* Not tiedto ORM or database work ... seperate project (just for doing validation)
//
//And the Hibernate Validator is fully compliant with the Java Bean's validation API, So that implementation spec to the T and it works out really nice. 
//
//About the Versions ... tricky!
//
//* Hibernate Validator 7 is based on Jakarta EE9
//* Jakarta EE is the community version of Java EE (rebranded, relicensed), (Java EE is a collection of enterprise APIs like Servlets, JSP, JDBC, Enterprise Java Beans,Java Message Service and so on.)
//* Allows innovation of Jakarta EE with community-driven approach (no long manage by continued by oracle)
//* Jakarta EE does not replace java EE
//	* Last version is Java EE 8 (Aug 2017)
//	* Jakarta EE is moving forward with Jakarta EE 9 (Dec 2020) and future release
//
//Jakarta EE
//* At the moment, main change with Jakarta EE... package renaming
//* javax.* packages are renamed to jakarta.*
//* For example
//	* javax.servlet.http.HttpServlet is now jakarta.servlet.http.HttpServlet
//
//Okay ... what impact on Hibernate Validator??
//* Hibernate Validator 7 is based on Jakarta EE 9
//* Spring is still based on some components of Java EE(javax.*)
//* Spring may use Jakarta EE components in the future ... but no news yet
//* As a result, Spring 5 is not compatible with Hibernate Validator 7.
//
//But wait ... I need to use latest version??
//
//* Two release of Hibernate Validator
//	* Hibernate Validator 7 is for Jakarta EE 9 projects
//	* Hibernate Validator 6.2 is compatible with Spring 5
//* Hibernate Validator 6.2 has the SAME features as Hibernate Validator 7
//	* So you are not being left behind by using Hibernate Validator 6.2
//	* Just tricky things with version numbers (also with the packaging So instead of packages being javax.*, jakarta.*)
//
//Development Process
//1. Download Validator JAR files from Hibernate Validator websites
//2. Add JAR files to project
//
//Required Fields
//Development Process
//1. Add validation rule to customer class
//2. Display error messages on HTML form
//3. Perform validation in the Controller class
//4. Update confirmation page
//
//1. 
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//public class Customer {
//	private String firstName;
//
//	@NotNull(message="is required")
//	@Size(min=1, message="is required")
//	private String lastName;
//}
//
//2. 
//Last name (*): <form:input path="lastName" />
//<form:errors path="lastName" cssClass="error" />
//
//3. @RequestMapping("/processForm")
//public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
//	if(theBindingResult.hasErrors()){
//		return "customer-form";
//	} else {
//		return "customer-confirmation";
//	}
//}
//
//@Valid, So basically you're saying "Perform validation rules on this customer object," and then also the results o that validation test will be placed in binding reulsts. So bind reult will be the result of the actual validation rule. 
//So behind the scene when spring calls this methods spring will perform the validation rules using the hibernate validator API, and then result will be the obj binding result.
//
//4. same above
//
//Special Note about BindingResult Parameter Order
//* When performing Spring MVC validation, the location of the BindingResult param is very important. In the method signature, the BindingResult parameter must appear immediately after the model attribute.
//
//If you place it in any other location, Spring MVC validation will not work as desired. In fact, your validation rules will be ignored.
//@RequestMapping("/processForm")
//public String processForm(
//	@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult
//){}
//
//Defining @RequestMapping methods
//@RequestMapping handler methods have a flexible signature and can choose from a range of supported controller method arguments and return values.
//
//The Errors or BindingResult parameters have to follow the model object that is being bound immediately ...
//
//
//White Space
//* Last name field with all whitespace passed ... 
//* Should have faild!
//
//* We need to trim whitespace from input fields, white space doesn't pass 
//
//Advanced
//@InitBinder
//* @InitBinder annotation works as a pre-processor
//* It will pre-process each web request to our controller
//* Method annoted with @InitBinder is executed
//so all requests coming in are pre-processed. Now, this is actually an adv annotation. Not many spring developers know about it, 
//
//* We will use the trim Strings
//	* Remove leading and trailing white page
//* If String only has white spaces ... trim it to null
//* Will resolve our validation problem ... whew?
//
//Register Custom Editor in Controller
//
//@InitBinder
//public void initBinder(WebDataBinder dataBinder){
//	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); (Defined in Spring API)
//
//	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//	// using the data binder I'll register this as a custom editor. So what I'm ding here is, I'm saying for every string class apply the trimmer editor 
//}
//
//* Pre-process every String form data
//* Remove leading and trailing white space
//* If String only has white space trim it to null
public class Customer {
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
//	27. Spring MVC Validation a Number Range
//
//	* Add a new input field on our form for: Free Passes
//	* User can only enter a range: 0 to 10
//
//	Development Process
//	1. Add validation rule to Customer class
//	2. Display error message on HTML form
//	3. Perfom validation in the Controller class
//	4. Update confirmation page
//
//	1. 
//
//	public class Customer {
//		@Min(value=0, message="must be greater than or equal to zero")
//		@Max(value=10, message="must be less than or equal to 10")
//		private int freePasses;
//
//		//getter/setter methods
//	}
//
//	So basically, we have new field have the customer class are called freePasses, so I'll define it as private int freePasses, actually make use of two new annotations to set up a validation rules I'll make use of an @Min and an @Max. 
//
//	Development Process
//	1. Add validation rule to Customer class
//	2. Display error messages on HTML form
//	3. Perform validation in the Controller class
//	4. Update confirmation page

	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equal to 10")
	private int freePasses;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
}
