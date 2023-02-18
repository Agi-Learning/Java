package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

//37. Fetch Types: Eager vs Lazy Loading
//Now when we load data, or we retrieve or fetch data, Q is should we retrieve everything? 
//* When we fetch / retrieve data, should we retrieve EVERYTHIMG?
//	* Eager will retrieve everything
//	* Lazy will retrieve on request
//
//we have a instructor, and have courses, depending on the loading type, that'll determain when and how the data is loaded from the database by Hibernate. And it also has an implication on your actual performance of your given app.
//
//Eager Loading
//* Eager loading will load all dependent entities
//	* Load instructor and all of their courses at once
//
//Now with eager loading, it'll actually load all your dependent entities, So it'll load the instructor and all of their courses at once. So it'll do a one quick shot to the db, grab all the data, and bring it back. Now this may not be a big deal if you only have a small number of instructor and a small number of courses. But u could imagine if you had a lot of data out there, that will actually impact the perfomance of your application  
//
//Example
//
//* So What about the course and students?
//* Could easily turn into a performance nightmare...
//check tab
//
//* So if we were to load a course and then actually load all of the students for the course then this could possibly slow down our app, or not even posibily most likely it will slow down our app bcz just like the course that you're attending now, a given course could have 10,000, 20,000 maybe 50,000 students. And we really don't need all that data at this point. 
//
//* In our app, if we're searching for a course by keyword 
//* Only want a list of matching courses.
//
//* Eager loading would still load all students for each course .... not good! 
//
//only want title or description of the courses but not all of the students. 
//
//So Best practice 
//* Only load data when absolutely needed
//* prefer Lazy loading instead of Eager loading
//
//Lazy Loading
//* Lazy loading will load the main entity first
//* Load dependent entities on demand (lazy)
//
//Real-World User Case
//
//* In Master view, use lazy loading
//* In Detail view, retrieve the entity and necessary dependent entities
//
//-- MV:
//* In Master view, use lazy loading for search results
//* Only load instructors ... not their courses
//
//I simply wanna high level view of instructors, but i am not really concerned about courses at the moment, If you want it course info we can select the link here, view detials, to actually drill down into that given instructor. so this is actually resolve in a faster query on our db app. 
//
//-- DV:
//* In Detail view, retrieve the entity and necessary dependent entities
//* Load instructor AND their course
//
//Fetch Type
//
//* When you define the mapping relationship
//* You can specify the fetch type: EAGER or LAZY
//
//@Entity
//@Table(name="instructor")
//public class Instructor {
//...
//@OneToMany(fetch=FetchType.Lazy, mappedBy="instructor")
//private List<Course> courses;
//...
//}
//
//Default Fetch Types
//
//Mapping			Default Fetch Type
//
//@OneToOne		FetchType.EAGER
//@OneToMany		FetchType.LAZY
//@ManyToOne		FetchType.EAGER
//@ManyToMany		FetchType.LAZY
//
//Overriding Default Fetch Type
//
//* Specifying the fetch type, overrides the defaults
//
//@ManyToOne(fetch=FetchType.LAZY)
//@JoinColumn(name="instructor_id")
//private Instructor instructor;
//
//we're gonna actually override that value and you simply just be explicit, you say many to one, fetch equals fetch.lazy
//
//More about Lazy Loading
//
//* When you lazy load, the data is only retrieved on demand 
//* However, caveat, this requires an open Hibernate session
//* need an connection to db to retrieve data
//
//* If the Hibernate session is closed
//* And you attempt to retrieve lazy data
//* Hibernate will throw an execption
//
//* To retrieve lazy data, you will need to open a Hibernate session
//* Retrieve lazy data using
//* Option 1: session.get and call appropriate getter methods
//* Option 2: Hibernate query with HQL
//* Many other techniques available but the 2 above are most common
//

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			// This is our main application how we can walk through the debug mode, here going to session.get at this point everything is loaded,. The instructor, instructorDetails and Courses. All because of the eager loading, so later print out the all courses so no need to hit the data anymore, i have all of that data loaded in memory. Now, again remember, depending on your use case, eager could be a good thing or bad thing. In general best practice is to make use of lazy loading. 
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			System.out.println("luv2code: Instructor: "+tempInstructor);
			
			// get course for the instructor
			// we dont get the courses we actually we request them.The courses are only loaded on demand when we call this getter And as we sawa on the application at that point hibernate submits another query to the database to actually load the courses for that given instructor. 
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// option 1: call getter method while session is open 
			System.out.println("\nluv2code: The session is now closed!\n");
			
			// This should fail, recall the courses in the memory while the session was opened, executed after the session closed
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!");
			
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
