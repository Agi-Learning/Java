package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//30. Hibernate Development Process
//To Do List
//
//1. Add Hibernate Configuration file
//2. Annotate Java Class
//3. Develop Java Code to perform database operations
//
//1.
//Configuration file basically tells hibernate how to connect to the database, And again Hibernate uses JDBC in the background for communicating with the DB. So the bulk of the info that we'll have in the config file is that JDBC url, user id, password and so on. 
//
//2.
//Entity Class
//Java class that is mapped to a database table, plain old java class with fields and getter or setter methods. And then you simply add annotations on it to help with mapping it to a database table. 
//2 options for Mapping
//* Option 1: XML config file(legacy)
//* Option 2: Java Annotations (modern, preferred)
//Java Annotations
//* Step 1: Map class to database table
//* Step 2: Map fields to database columns 
//
//@Entity
//@Table(name="student")
//public class Student {
//	...
//}
//because our case the java class name has the same name as the database table. but just for completeness i always give to explicit name here so we know what we want exactly too. 
//
//@Id
//@Column(name="id")
//private int id;
//
//@Column(name="first_name")
//private String firstName;
//
//If you are using Java 9,10,11 then you will encounter an error when you run your hibernate program.
//
//Error: Exception in thread "main"
//java.lang.NoClassDefFoundError:
//javax/xml/bind/JAXBException
//
//Solution
//For java 9 and higher, you need to additional JAR files.
//You need to download the following JAR files:
//
//javax.activation-1.2.0.jar
//jaxb-api-2.3.0.jar
//jaxb-core-2.3.0.jar
//jaxb-impl-2.3.0.jar
//
//Error: import of the javax.persistance.GenerationType saying its not accessible
//
//JAVA 9 USERS Generate toString() fails
//As a work around, you will need to manually write the code for toString().
//
//
//why we are using JPA Annotation instead of Hibernate?
//
//JPA is a standard specification. Hibernate is an implementation of the JPA specification.
//
//Hibernate implements all of the JPA annotations
//The Hibernate team recommends the use of JPA annotations as a best practice
//can Hibernate generate database tables based on the java code?
//Yes you can generate database tables from Java code.

@Entity
@Table(name="student")
public class Student {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}





