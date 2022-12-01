package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//36. Hibernate Adv Mapping @OnetoMany - Overview
//Check on Tab:
//One-to-Many Mapping
//	* An instructor can have many courses
//		* Bi-directional
//Many-to-One Mapping
//	* Many courses can have one instructor
//		* Inverse / opposite of One-t0-Many
//
//Real-World Project Requirement
//	* If you delete an instructor, DO NOT delete the courses
//	* If you delete a course, DO NOT delete the instructor
//
//Development Process: One-to-Many
//
//	1. Prep Work - Define database tables
//	2. Create Course class
//	3. Update Instructor class
//	4. Create Main App
//
//
//table: course
//File: create-db.sql
//
//CREATE TABLE `course` (
//	`id` int(11) NOT NULL AUTO_INCREMENT,
//	`title` varchar(128) DEFAULT NULL,
//	`instructor_id` int(11) DEFAULT NULL,
//
//	PRIMARY KEY (`id`)
//	UNIQUE KEY `TITLE_UNIQUE` (`title`),
//	// to prevent duplicate course title Make sure you donot have multiple course with title  if you trying add a course to the title, duplicate to the title the database actually give you an error.
//	...
//);
//
//table: course - foreign key
//File: create-db.sql
//
//CREATE TABLE `course` (
//	...
//	KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
//	CONSTRAINT `FK_INSTRUCTOR`
//	FOREIGN KEY (`instructor_id`)
//	REFERENCES `instructor` (`id`)
//	...
//)
//
//
//we will basically need to setup between the course and the instructor. So we have this foreign key for instructor ID, basically refs maps back to the instructor table the ID column of that instructor table. so that our FK relationship
//as its no changes to the SQL for the instructor table which is a good things.
//
//Step 2: Create Course class
//
//@Entity
//@Table(name="course")
//public class Course {
//	...	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//
//	@Column(name="title")
//	private String title;
//
//	@ManyToOne
//	@JoinColumn(name="instructor_id")
//	private Instructor instructor;
//
//	// constructors, getters / setters
//	...
//}
//
//Course table that map associate to the instructor table so we can find the given instrutor for this given course, So that's the purpose of the join column, So it basically refs the column that's in our course table that allow us to map back and find the associated instructor. 
//
//Step 3: Update Instructor - ref courses
//
//@Entity
//@Table(name="instructor")
//public class Instructor {
//	...
//	@OneToMany(mappedBy="instructor")
//	private List<Course> courses;
//
//	public List<Course> getCourse() {
//		return courses;
//	}
//
//	public void setCourse(List<Course> courses) {
//		this.courses = courses;
//	}
//	...
//}
//
//More on mappedBy
//* mappedBy tells Hibernate
//	* Look at the instructor property in the Course class
//	* Use info from the Course class @JoinColumn
//	* To help find associated courses for instructor
//
//Add support for Cascading
//
//@Entity
//@Table(name="instructor")
//public class Instructor {
//	...
//	@OneToMany(mappedBy="instructor",
//				cascade={CascadeType.PERSIST, CascadeType.MERGE
//						CascadeType.DETACH, CascadeType.REFRESH})
//	private List<Course> courses;
//	...
//	// constructors getter setters
//}
//
//Add convenience methods for Bi-Directional
//
//public void add(Course tempCourse){
//	if(courses == null){
//		courses = new ArrayList<>();
//	}
//	courses.add(tempCourse); // this is mean two instructor course Bi-directional link
//	tempCourse.setInstructor(this);
//}
//
//Step 4: Create Main App
//
//// get the instructor object
//int theId = 1;
//Instructor tempInstructor = session.get(Instructor.class, theId);
//
//// print instructor
//System.out.println("tempInstructor: "+tempInstructor);
//
//// print the associated courses
//System.out.println("courses: "+tempInstructor.getCourses());


public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			Instructor tempInstructor = 
					new Instructor("Susan", "Public", "susan.public@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com",
							"Video Games");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// Save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}	 finally {
			
			// add close up code
			session.close();
			factory.close();
		}

	}

}
