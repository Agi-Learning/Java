package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//27. Spring Custom Validation Demo
//* Perfome custom validation based on your business rules
//	* course code must start form LUV
//* Spring MVC calls our custom validation
//* Custom validation returns boolean value for pass/fail (true/false)
//
//Create a custom Java Annotation ... from scratch
//* So far, We've used predefined validation rules: @Min, @Max,...
//* For custom validation ... we will create a Custom Java Annotation
//	* @CourseCode this is the validation rule that actually apply to the field
//
//@CourseCode(value="LUV", message="must start with LUV")
//private String courseCode;
//
//Development Process
//1. Create custom validation rule
//2. Add validation rule to Customer class
//3. Display error message on HTML form
//4. Update conformation page
//
//1. 
//a. Create @CourseCode annotation
//b. Create CourseCodeConstraintValidator
//(this will allow you to own validation logic or own business rules to determine t/f if the value passes our validation.)
//
//a. 
//@CourseCode(value="LUV", message="must start with LUV")
//private String courseCode;
//the value course must start with, error message if the value fails, field in our entity class: Student.java
//
//@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//@Target({ ElementType.METHOD, ElementType.FIELD })
//@Retention(RetentionPolicy.RUNTIME)
//public @interface CourseCode {
//
//public String value() default "LUV";
//// then user doesn't provide a value the defaul value of LUV
//
//public String message() default "must start with LUV";
//}
////first thing we notice that we creating the annotation, you make use of some special syntax, here we have public @interface CourseCode. 
////can apply our annotation to a method or field, how long should be retain it, Retain this annotation in the java class file, Process it at runtime. 
//
//b. CourseCodeConstraintValidator
//public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
//private String coursePrefix;
//
//@Override
//public void initialize(CourseCode theCourseCode){
//	coursePrefix = theCourseCode.value();
//}
//
//@Override
//public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext){
//	boolean result;
//	if(theCode != null){
//		result = theCode.startsWith(coursePrifix);
//	} else {
//		result = true;
//	}
//	return result;
//}
//}
//
//Helper class:
//Contains business rules for validation, That give you true, false pass a actual parameter 
//
//CourseCodeConstraintValidator implements ConstraintValidater, CV has generics, So they'll pass in the actual CourseCode annotation, and the actual type of data that we're validating against, Then i setup my field here, private String coursePrefix and then i have public void initialize. So when they create the validator they actually intialize it. So I get a handle to the actual annotation that was passed in and i say theCourseCode.value
//
//So that give me the actual prefix that we've gonna use to validate data against. So this is basically sets everything So our validator's up and running it's ready Someone can actually use it, is this given value valid? Then take up to next level isValid
//
//So this is what Spring MVC will call at runtime when actually said the user just submitted a form, here's the data. is the data valid And then we apply our bussiness rules to it. 
//
//So they'll call isValid pass in String theCode. the code is data from the form They'll also pass in a ConstraintValidatedContext, 

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result; 
		
		if(theCode !=  null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			result = true;
		}
		return result;
	}
}

//Spring MVC Custom Validation - Possible to validate with multiple strings?
//Ans: 
//* Yes, you can do this. In your validation, you will make use of an array of strings.
//Here's an overview of the steps
//1. Update CourseCode.java to use an array of strings
//2. Update CourseCodeConstraintValidator.java to validate against array of strings
//3. Update Customer.java to validate using array of strings
//
//1. Change the value entry to an arrya of Strings:
//	// define default course code
//	public String[] value() default {"LUV"};
//2. Change field for coursePrefixes to an array
//	private String[] coursePrefixes;
//Update the isValid(...) method to loop through the course prefixes. In the loop, check to see if the code matechs any of the course prefixes.
//
//@Override
//public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext){
//	boolean result = false;
//	if(theCode != null){
//		// loop thru course prefixes
//		// check to see if code matches any of the course prefixes
//		for (String tempPrefix : coursePrefixes){
//			result = theCode.startsWith(tempPrefix);
//
//			// if we found a match then break out of the loop
//			if(result){
//				break
//			}
//		}
//	}
//}
//
//3. 
//@CourseCode(value={"TOPS", "LUV"}, message="must start with TOPS or LUV")
//private String courseCode;
