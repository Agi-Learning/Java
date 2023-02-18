package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

//38. One-to-Many Mapping Uni-Directional
//
//* A course can have many reviews
//	* Uni-directional
//
//Check Tab
//
//Real-World Project Requirement
//
//* If you delete a course, also delete the reviews
//* Rieviews without a course ... have no meaning 
//
//Development Process: One-to-Many
//
//1. Prep Work - Define database tables
//2. Create Review class
//3. Update Course class
//4. Create Main App
//
//Step 1: table: review
//
//File: create-db.sql
//
//CREATE TABLE `review` (
//	`id` int(11) NOT NULL AUTO_INCREMENT,
//	`comment` varchar(256) DEFAULT NULL,
//	`course_id` int(11) DEFAULT NULL,
//	...
//);
//
//table review: foreign key
//
//File: create-db.sql
//
//CREATE TABLE `review` (
//	...
//	KEY `FK_COURSE_ID_idx` (`course_id`),
//	CONSTRAINT `FK_COURSE`
//	FOREIGN KEY (`course_id`)
//	REFERENCES `course` (`id`) 
//	...
//);
//
//
//Step 2: Create Review class
//
//@Entity
//@Table(name="review")
//public class Review {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//
//	@Column (name="comment")
//	private String comment;
//
//	...
//	// Constructors, getters / setters
//}
//
//Step 3: Update Course - reference reviews
//
//Add @OneToMany annotation
//
//@Entity
//@Table(name="course")
//public class Course {
//	...
//
//	@OneToMany
//	@JoinColumn(name="course_id")
//	private List<Reviews> reviews;
//	// getters / Setters
//}
//
//More: @JoinColumn
//* In this scenario, @JoinColumn tells Hibernate
//	* Look at the course_id column in the review table 
//	* Use this information to help find associated reviews for a course 
//	foriegn key column maps back to course table and their given ID. So that's how we kind of associate everything together and pull it all together for a course and a collection of reviews. 
//
//Add support for Cascading and Lazy
//
//@Entity
//@Table(name="course")
//public class Course {
//	...
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name="course_id")
//	private List<Review> reviews;
//
//	...
//}
//
//Add convenience method for adding review
//
//@Entity
//@Table(name="course")
//public class Course {
//	...
//	// add convenience methods for adding reviews
//
//	public void add(Review tempReview){
//		if (reviews == null) {
//			reviews = new ArrayList<>();
//		}
//
//		reviews.add(tempReview);
//	}
//}
//
//Step 4: Create Main App
//
//public static void main(String[] args){
//	...
//	// get the course object
//	int theId = 10;
//	Course tempCourse = session.get(course.class, theId);
//
//	// print the course
//	System.out.println("tempCourse: " + tempCourse);
//
//	// print the associated reviews
//	System.out.println('reviews: ' + tempCourse.getReviews());
//
//	...
//}
public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		// ERR: Use of @OneToMany or @ManyToMany targeting an unmapped class: com.luv2code.hibernate.demo.entity.Course.reviews
		// Add Review class
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("pacman - How To Score One Million Points");
			
			// add some reviews
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			
			// save the course ... and leverage the cascade all :- )
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
