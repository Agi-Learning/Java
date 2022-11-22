package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//How to read Dates with Hibernate
//
//FAQ: Handling Dates with Hibernate
//How can I read date strings from the command-line and store them as dates in the DB?
//
//Ans: You can make use of a combination of Java's date formatting class and Hibernate annotations.
//
//Sample output:
//
//Student [id=50, firstName=Paul, lastName=Doe, email=paul@luv2code.com, dateOfBirth=null]
//Student [id=51, firstName=Daffy, lastName=Duck, email=daffy@luv2code.com, dateOfBirth=null]
//Student [id=52, firstName=Paul, lastName=Doe, email=paul@luv2code.com, dateOfBirth=31/12/1998]
//
//Development Process Overview
//1. Alter database table for student
//2. Add a date utils class for parsing and formatting dates
//3. Add date field to Student class
//4. Add toString method to Student class
//5. Update CreateStudentDemo
//
//Detailed steps
//1. Alter database table for student
//We need to alter the database table to add a new column for "date_of_birth".
//Run the following SQL in your MySQL Workbench tool.
//
//ALTER TABLE `hb_student_tracker`.`student` ADD COLUMN `date_of_birth` DATETIME NULL AFTER 'last_name';
//
//2. Add a date utils class for parsing and formatting dates
//We need to add a DateUtils class to handle parsing and formatting dates. The source code is here. The class should be placed in the package: com.luv2code.hibernate.demo.
//
//The date formatter uses special symbols for formatting/parsing.
//
//- dd: day in month(number)
//- MM: month in year(number)
//- yyyy: year
//
//3. Add date field to Student class
//We need to add a date field to the Student class. We map this field to the DB column, "date_of_birth". Also, we make use of the @Temporal annotation. This is a Java annotation for storing dates.
//
//@Column(name="date_of_birth")
//@Temporal(TemporalType.DATE)
//private Date dateOfBirth;
//
//4. Add toString method to Student class
//We will make an update to the toString method in our Student class. It will use the formatter from our DateUtils.class. This code is already included in Student.java from the prev step. 
//
//5. Update CreateStudentDemp
//
//Now for the grand finale. In the main program, read the date as a String and parse/convert it to a date. 
//String theDateOfBirthStr = "31/12/1998";
//Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
//Student tempStudent = new Student("pauly", "Doe", "paul@luv.com", theDateOfBirth);

public class DateUtils {
	// The date formatter
	// -- dd: day in month(number)
	// -- MM: month in year(number)
	// -- yyyy: year
	// See this link for details:
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	// read a date string and parse/convert to a date
	public static Date parseDate(String dateStr) throws ParseException {
		Date theDate = formatter.parse(dateStr);
		return theDate;
	}
	
	// read a date and format/convert to a string
	public static String formatDate(Date theDate) {
		String result = null;
		if(theDate !=  null) {
			result = formatter.format(theDate);
		}
		return result;
	}
}





