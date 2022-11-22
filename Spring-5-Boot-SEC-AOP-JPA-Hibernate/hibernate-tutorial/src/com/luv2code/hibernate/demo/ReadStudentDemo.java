package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

//33. Reading Objects with hibernate
//
//Retrieving a Java Object with Hibernate
//
//// create java object
//Student theStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
//
//// save it to database
//session.save(theStudent);
//
//// now retrieve/read from database using the primary key
//Student myStudent = session.get(Student.class, theStudent.getId());
//
//In the hibernate you will retrieve an object from the DB using its primary key, So here I make use of session.get I give the Student.class and then I specify the primary key, So here i say theStudent.getId or i hardcode the primary key value there If i'd like But either way you need to provide a primary key here for it to actually retrieve the object and then we can assign it as myStudent. it'll query the DB, populate the object, put the data in there, and then return that object. Now if the object is not found for that primary key, then this session i get will simply return null 
//Using PK you find then object from the DB, 

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

			// start transaction
			session.beginTransaction();

			// save the student
			System.out.println("Saving the student...");
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			
			
			// MY NEW CODE
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: "+myStudent);
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
