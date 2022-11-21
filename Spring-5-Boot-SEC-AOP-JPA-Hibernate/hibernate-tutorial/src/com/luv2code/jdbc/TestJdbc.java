package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
//29. Hibernate
//
//What is Hibernate?
//* A framework for persisting / saving java object in a database
//
//Java App <----> Hibernate <----> Database
//
//Its a very popular framework used by a lot of enterprise java projects. But basically very high level you'll have your java application, It'll make use of this hibernate framework, and use of saving and retrieving data from the database. 
//
//Benefits of Hibernate:
//* Hibernate handle all of the low-level SQL 
//* Minimizes the amount of JDBC code you have to develop
//* Hibernate provides the Object-to-Relational Mapping (ORM) (it makes it really easily to create apps that store and retrieve objects from the db)
//
//Object-To-Relational Mapping (ORM)
//	* The developer defines mapping between Java class and database table
//
//Java Class   <---->  Hibernate <----> Database Table
//
//So you need to tell how java class or object, how it maps to data in the database. And in fact you gonna map your java class to a given database table. 
//
//Java said hey this java class student maps to this given table, And you set up the one-to-one mapping between the fields and the actual columns in the database.
//Now you setup this mapping via the configuration file using XML, or you can set it up using Java annotations, 
//
//Saving a Java Object with Hibernate
//
//// Create Java object
//Student theStudent = new Student("John", "Doe", "john@luv2code.com");
//
//// save it to database
//int theId = (Integer) session.save(theStudent);
//
//then save the java object to the database, So here we make use of session, which is a special hibernate object, which session.save and then we pass in our object, What happens in the background is that hibernate will take the java object based on those mapping that have been defined earlier. Hibernate will take that information and store it in the appropriate table in the appropriate columns, 
//
//So if you remember back in the old days of JDBC, you would manually have to write the SQL code, manually set this values, and manually execute that SQL statement, but here Hibernate does all of that work for you, which is really cool
//And once you do the session.save, then Hibernate will return the actuall ID, that's been assigned to that entry, and this is actually the primary key, and we can use that ID later if we wanted to actually retrieve the object from the database, really easy to save the java object actual hibernate. 
//
//// now retrieve from database using the primary key
//Student myStudent = session.get(Student.class, theId);
//
//So here i am going to use this session.get i tell it what want to get Student.class and I give the ID So behind the scenes, hibernate say 'let me go to the students this table called student, and then let me find the student whose primary key matches this id. They'll find the student object, and then return it to you and that's it. 
//
//that is basic thing how to retrieve basic java object from the database and again, Hibernate will do all the low-level work of doing the query, getting the actual data, constructing the object, and then returning it back to your program.
//Hibernate it minimize the lot of JDBC code you have to write in the past 
//
//Querying for Java Objects
//
//Query query = session.createQuery("from Student");
//List<Student> students = query.list();
//
//Hibernate supports queries So here I'll say session.createQuery, and I'll from student, So it'll basically give you a list of all those student objects from the student table and then return it to you as a list of student objects and that's it. 
//
//Here we are using HQL (Hybernate Query Language)
//Hibernate CRUD apps 
//Create objects
//Read objects
//Update objects
//Delete objects
//
//
//Hibernate and JDBC
//
//* Hibernate uses JDBC for all database communications
//
//Hibernate is a another layer of abstraction on top of JDBC. So when your application uses the Hibernate framework, your app will store and retrieve objects using the Hibernate API. In the background Hibernate does all of the low-level JDBC work and submitting the SQL query so on, So Hibernate does a lot of the low-level work for you but in the background it all goes through the standard JDBC API. 
//
//
//To Do List
//
//1. Create Eclipse Project
//2. Download Hibernate Files
//3. Download MySQL JDBC Driver
//4. Add JAR files to Eclipse Project ... Build Path
//
//Hibernate Versions
//* In March 2022, a new version of Hibernate 6 was released
//* Hibernate 6 supports Jakarta EE9
//	* Renamed packages: javax.* to jakarta.*
//	* This is a breaking change
//* Spring 5 currently does not support the new package renaming Jakarta EE 9
//* As a result, Spring 5 does not currently work on Hibernate 6.
//* Use Hibernate 5 for your Spring 5 apps

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: "+ jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!!"+myConn);
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
