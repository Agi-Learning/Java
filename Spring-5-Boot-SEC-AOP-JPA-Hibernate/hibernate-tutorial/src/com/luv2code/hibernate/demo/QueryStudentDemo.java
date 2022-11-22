package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

//Hibernate Query Language (HQL)
//* Query language for retrieving objects
//* Similar in nature to SQL
//	* where, like, order by, join, in, etc...
//
//Retrieving all Students
//
//List<Student> theStudents = 
//				session
//				.createQuery("from Student")
//				.getResultList();
//
//List<Student> theStudents = 
//				session
//				.createQuery("from Student s where s.lastName='Doe'")
//				.getResultList();
//
//List<Student> theStudents = 
//				session
//				.createQuery("from Student s where s.lastName='Doe'" 
//							+ " OR s.firstName='Daffy'")
//				.getResultList();
//
//List<Student> theStudents = 
//				session
//				.createQuery("from Student s where" 
//							+ " s.email LIKE '%luv2code.com'")
//				.getResultList();
//
//Deprecated Method in Hibernate 5.2
//
//Replace
//session.createQuery("from Student").list();
//
//With
//session.createQuery("from Student").getResultList();


public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents =  session.createQuery("from Student").list();
			
			// display the students
			displayStudents(theStudents);
			// Query students: lastName='Doe'
			theStudents =  session.createQuery("from Student s where s.lastName='Doe'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			// Query students: lastName='Doe'
			theStudents =  session.createQuery("from Student s where s.lastName='Doe'" + " OR s.firstName='Daffy'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
			displayStudents(theStudents);
			
			// Query students where email LIKE '%luv2code.com'
			theStudents =  session.createQuery("from Student s where" 
							+ " s.email LIKE '%luv2code.com'").list();
			
			// display the students
			System.out.println("\n\nStudents who have ends with luv2code.com");
			displayStudents(theStudents);
			
			// Query students where email LIKE '%luv2code.com'
			theStudents =  session.createQuery("from Student s where" 
							+ " s.email LIKE '%gmail.com'").list();
			
			// display the students
			System.out.println("\n\nStudents who have ends with gmail.com");
			displayStudents(theStudents);
						
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
//How to View Hibernate SQL parameter Values
//Q: I see hibernate printing out the query parameters as ? in the console. Is it possible to printout the value that was actually queried on the DB. Asking as this would help in the debugging purpose.
//
//A: When using Hibernate, If you log the Hibernate SQL statements, you will see this:
//
//Hibernate: insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
//However, for debugging your application, you want to see the actual parameter values in the hibernate logs. Basically, you want to get rid of the question marks in the Hibernate logs.
//
//Here is an overview of the process:
//1. Add Logback support to your project classpath
//2. Create Logback configuration file
//3. Run the CreateStudentDemp app


