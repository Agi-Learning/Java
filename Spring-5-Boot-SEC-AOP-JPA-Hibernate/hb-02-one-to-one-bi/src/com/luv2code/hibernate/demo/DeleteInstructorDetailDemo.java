package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

//New Use Case
//* If we load an InstructorDetail
//	* Then we'd like to get the associated Instructor
//
//* Can't do this with current uni-directional relationship :-
//
//Bi-Directional
//* Bi-Directional relationship is the solution
//* We can start with InstructorDetail and make it back to the Instructor
//
//The Good News
//* To use Bi-Directional, we can keep the existing DB schema.
//	* No changes required to DB
//
//* Simply update the Java code
//
//Development Process: One-to-One (Bi-Directional)
//
//1.Make updates to InstructorDetail class:
//	1. Add new field to ref Instructor
//	2. Add getter/setter methods for Instructor
//	3. Add @OneToOne annotation
//
//2. Create Main App
//
//1.1
//private Instructor instructor;
//
//public Instructor getInstructor() {
//	return instructor;
//}
//
//public void setInstructor(Instructor instructor){
//	this.instructor = instructor;
//}
//
//1.2
//@OneToOne(mappedBy="instructorDetail")
//private Instructor instructor;
//
//Refers to "instructorDetail" property in "Instructor" class
//
//More on mappedBy
//* mappedBy tells Hibernate
//	* Look at the instructorDetail property in the Instructor class
//	* Use info from the Instructor class @JoinColumn
//	* To help find associated instructor
//
//Hibernate will go figure that out, look at the FK relationship and match everything up so effectively Hibernate can use this info to find out how these 2 items are linked up, and also finding the appropriate instructor for this given instructor detail. 
//
//Add support for Cascading
//cascade=CascadeType.ALL
//
//this will actually cascade all operations to the assiciated instructor, so if I load an instructor detail, then if i wanna delete that instructor detail, this'll also cascade the delete operation to the given instructor. And remember you have fine grain control over the cascading types so if you don't want to cascade all you can choose the appropriate cascade types that you'd like to use for your given use case. 
//
//2
//
//// get the instructor detail object
//int theId = 1;
//InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
//
//// print detail
//System.out.println("tempInstructorDetail: "+tempInstructorDetail);
//
//// print the associated instructor
//System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());


public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 7;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print detail
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());

			// now let's delete the instructor detail 
			System.out.println("Deleting tempInstructorDetail: "+tempInstructorDetail);
			
			// remove the associated object reference
			// break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
		} catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			// handle connection leak issue (No more leaks)
			session.close();
			factory.close();
		}

	}

}
