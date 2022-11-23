package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			int theId = 60;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print detail
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());

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
