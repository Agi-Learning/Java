package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

//31. Creating and Saving Java Objects
//
//2 Key Players
//class 						Description
//SessionFactory -->         		Reads the hibernate config file Create Session objects
//							Heavy-weight object Only create once in your app
//
//Session        -->			Wraps a JDBC connection Main object used to save/      				                retrieve objects Short-lived object Retrieved from SessionFactory 
//
//Java Code Setup
//public static void main(String[] args){
//	SessionFactory factory = new Configuration()
//							.configure("hibernate.cfg.xml")
//							.addAnnotatedClass(Student.class)
//							.buildSessionFactory();
//
//	Session session = factory.getCurrentSession();
//
//	try {
//		// now use the session object to save/retrieve Java objects
//	} finally {
//		factory.close();
//	}
//}
//This session object is a heavy-weight object, you really only create it once and then you reuse it x number of times throughout your application. 
//Then i can use this factory to get a handle to a given session. So I say "factory.getCurrentSession();" It'll give me a session object, and then i can use it to perform a database operation. So, the normal pattern you'll have like, a try catch block or a try finally block, inside of the try block you actually use the session object to either save java objs or retrieve java objs. 
//
//Once we create the sessionFactory when we say ".configure", and i gave the actual name of the Hibernate configuration file, that's actually not required. You can simply say ".configure", open parent close parent
//by default, Hibernate will look for a file name on your class path called "hibernate.cfg.xml", However, I like to be explicit during training just to show you, "Hey Hibernate's gonna look for a given file". However, the file name's not required as long as you use the default file name. But anyway, just wanted to give you the background on that
//
//Save a Java Object
//
//try {
//	// create a student object
//	Student tempStudent = new Student("paul", "Wall", "paul@luv2code.com");
//
//	// start transaction
//	session.beginTransaction();
//
//	// save the student
//	session.save(tempStudent);
//
//	// commit the transaction
//	session.getTransaction().commit();
//} finally {
//	factory.close();
//}
//
//Now, behind the scenes, right, Hibernate knows how to connect to our database based on our configuration file. Hibernate also knows how to map this student class or object to the actual database, based on those annotations we took care of in the prev video. So hibernate knows kinda where things should fall. So here I say "session.save", puts it in the database. And then I also do a commit on this transaction. So here as session.getTransaction().commit(). and that actually stores it in the database once i do a commit. There's also a rollback method if you'd like to do that, If you're not happy with this transaction.

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object...");
			
			String theDateOfBirthStr = "31/12/1998";
			
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			Student tempStudent = new Student("Paul", "Doe", "paul@luv.com");
//					, theDateOfBirth);

			// start transaction
			session.beginTransaction();

			// save the student
			System.out.println("Saving the student...");
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
