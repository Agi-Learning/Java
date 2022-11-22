package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


//34. Updating Objects with Hibernate
//
//Update a Student
//int studentId = 1;
//Student myStudent = session.get(Student.class, studentId);
//
//// update first name to "Scooby"
//myStudent.setFirstName("Scooby");
//
//// commit the transaction
//session.getTransaction().commit();
//We already have transaction created and we've already started a transaction, Then i wanna do is get a student using the primary key, So using info from the previous videos here, I'll say session.get student.class And I set the studentId to 1, So that'll give me a student object So I've retrieved a student object from the DB. 
//
//this student object that I just retrieved, So what i can do is I can actually use that student and simply set a property, So here I can say my student.set first name to Scooby, so point only in memory, but then once we commit the transaction, then that'll actually apply, to the information in the DB. or it'll actually update the DB.
//
//So one thing that's important here to notice is that we simply retrieve the object, we set a value and then we commit the transaction, There's no hard requirement for us to call session.update because this student object is a persistent object that we retrieved from the DB. We can simply call the appropriate setters and then finally do a commit and that'll actually update the DB, Which is something that's a little tricky It's not what you're commonly used to seeing but once you understand it, it's actually really cool. So there's no need to explicitly call, save or update. You simply commit the transaction. 
//
//Update email for all students
//session
//	.createQuery("update Student set email='foo@gmail.com'")
//	.executeUpdate();


public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='foo@gamil.com'")
					.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
