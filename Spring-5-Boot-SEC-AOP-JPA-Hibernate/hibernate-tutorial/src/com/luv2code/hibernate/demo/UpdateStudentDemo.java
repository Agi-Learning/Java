package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

//35. Deleting Objects with Hibernate - Overview
//
//Delete a Sudent
//
//int studentId = 1;
//
//Student myStudent = session.get(Student.class, studentId);
//
//// delete the student
//session.delete(myStudent);
//
//// commit the transaction
//session.getTransaction().commit();
//
//Hibernate actually delete the student or to delete the object, we make use of session.delete and this'll actually delete the student, so session.delete, and you give the object reference and then you actually perform a commit on the transaction to make it actually apply to the database. But that's it, so the key here is retrieve the object and then you do a session.delete 
//
//Another way of deleting 
//session
//	.createQuery("delete from Student where id=2")
//	.executeUpdate();
//
//you had to retrieve the object first to delete it, Here we don't really wanna retrieve it We simply wanna delete it kinda on the fly, So you can do that by saying session.createQuery delete from Student where id= and you enter whatever the ID value is, in this case 2. So that'll actually delete the object from the database So you say createQuery delete from Student where id= .executeUpdate, its a generic name, So it basically means that you're updating the DB.
//
//That update could be an update statement or a delete. It doesn't really care, so update in a very generic sense. So here that's how we delete Now with your where clause, you could set any values. You could say delete from student where not registered equals yes or whatever values you have. You can get as fancy as you want for your where clause as far as performing a delete. So this could apply to a single student or based on your where clause, it could apply to multiple students. All right, so that's the other way of performing a delete. 
//
//Can see actually perform deletes on the DB using Hibernate. 


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
			
			// delete the student
			// System.out.println("\n Delete student: "+myStudent);
			// session.delete(myStudent);
			
			// delete student id=2
			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}

//Hibernate Development
//
//Overview
//Create an app using Hibernate to read/write data to database table. Here is the database table design:
//
//Table: Employee
//Columns
//-id: int
//-first_name: varchar
//-last_name: varchar
//-company: varchar
//
//Steps you must complete
//
//1. create the database table.
//2. Set up the Hibernate config file.
//3. Create a Java class(entity) with Hibernate annotations
//4. Develop a main application.
//5. Develop code to save objects
//6. Develop code to retrieve an object by primary key.
//7. Develop code to query objects to find employees for given company.
//8. Develop code to delete an object by primary key.
