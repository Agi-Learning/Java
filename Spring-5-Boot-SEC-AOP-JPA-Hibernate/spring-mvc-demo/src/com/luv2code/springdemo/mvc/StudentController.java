package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//25. Spring MVC form Tags
//
//* Spring MVC form Tags are the building block for a web page
//* Form Tags are configurable and reusable for a web page
//
//Data Binding
//* Spring MVC Form Tags can make use of data binding
//* Automatically setting / retrieving data from a Java object / bean
//
//Web Page Structure
//* JSP page with special Spring MVC Form tags
//<html>
//	... regular html ...
//	... Spring MVC form tags ...
//	... more html ...
//</html>
//
//How To referece Spring MVC Form Tags
//* Specify the spring namespace at beginnings of JSP file
//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
//
//Spring form tags for Text feilds
//In your spring controller
//* Before you show the form, you must add a model attribute
//* This is a bean that will hold form data for the data binging
//
//// to bind our form data to our bean
//
//Show Form - Add Model Attribute
//@RequestMapping('/showForm')
//public String showForm(Model theModel){
//	theModel.addAttribute("student", new Student());
//	return "student-form";
//}
//
//Setting up HTML Form - Data Binding
//
//<form:form action="processForm" modelAttribute="student">
//	First name: <form:input path="firstName" />
//	<br/><br />
//	Last name: <form:input path="lastName" />
//	<br /><br />
//	<input type="submit" value="Submit" />
//</form:form>
//
//this is actually bind to prop on the bean. spring actually populate the form field 
//When i have a firstName Spring MVC will get student.getFirstName(). and use a model attribute from up top to retrieve that data. If its null, then that form field will simply be empty. 
//
//Handling Form Submission in the Controller
//@RequestMapping("/processForm")
//public String processForm(@ModelAttribute("student") Student theStudent) {
//	// log the input data
//	sysout("theStudent: "+theStudent.getLastName());
//	return "student-confirmation"
//}
//
//In our controller you can make use of a new Spring annotation called @ModelAttribute, So again we're using student in our lower case, they'll actually bind that object to the parameter being passed in student
//In bind the scence take that model attribute and bind it to this variable here, the student and we can use it in our controller 
//
//Confirmation page
//<html>
//	<body>
//		The student is confirmed: ${student.firstName} ${Student.lastName}
//	</body>
//</html>
//
//Development Process
//
//1.create Student Class
//2. Create Student controller class
//3. Create HTML form
//4. Create form processing code
//5. Create confirmation page

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// log the input data
		System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}
}
