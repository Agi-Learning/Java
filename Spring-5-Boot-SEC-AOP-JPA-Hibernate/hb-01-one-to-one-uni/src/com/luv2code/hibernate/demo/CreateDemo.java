package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

//35. Hibernate Adv Mapping @OneToOne
//One-to-One Mapping
//* An instructor can have an "instructor detail" entity
//	* Similar to an "instructor profile"
//
//Now this example Unidirectional so basically Starts with the instructor and then we'll have a one-way relationship with the instructor detail. 
//
//Development Process: One-to-One
//
//1. Prep Work - Define database tables
//2. Create InstructorDetail class
//3. Create Instructor class
//4. Create Main App
//
//1.
//table: instructor_detail
//
//File: create-db.sql
//
//CREATE TABLE 	`instructor_detail` (
//	`id`	int(11) NOT NULL AUTO_INCREMENT,
//	`youtube_channel` varchar(128) DEFAULT NULL,
//	`hobby` varchar(45) DEFAULT NULL,
//	PRIMARY KEY (`id`)
//)
//
//We'll add one other entry here for primary key. So basically telling the system the PK for this table is ID. 
//
//table:instructor
//
//File: create-db.sql
//
//CREATE TABLE `instructor` (
//	`id`	int(11)		NOT NUL AUTO_INCREMENT,
//	`first_name`	varchar(45) DEFAULT NULL,
//	`last_name`		varchar(45) DEFAULT NULL,
//	`email` 	varchar(45) DEFAULT NULL,
//	`instructor_detail_id` int(11) DEFAULT NULL,
//	PRIMARY KEY (`id`)
//	...
//);
//
//So at this point we have 2 seperate tables, We have an instructor detail table and an instructor table. But we somehow need to link those tables together. 
//
//Foreign Key
//* Will allows to link tables together
//* A field in one table that refers to PK in another table
//
//So we'll actually have a field in the instructor table, that'll be the instructor detail ID, It's gonna refer to the PK in the instructor detail table. 
//
//Defining Foreign Key
//
//CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
//REFERENCE `instructor_detail` (`id`)
//
//So we're gonna set up a constraint, which is a foreign key and its gonna map the instructor detail ID and it'll actually ref the instructor detail table and it will ref the ID in that instructor detail table.So that's how you setup the foreign key.
//
//More on Foreign Key
//
//* Main purpose is to preserve relationship between tables
//	* Referential Integrity
//
//* Prevents operations that would destroy relationship
//* Ensures only valid data is inserted into the foreign key column
//	* Can only contain valid ref to PK in other table
//2.
//
//@Entity
//@Table(name="instructor_detail")
//public class InstructorDetail {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//
//	@Column(name="youtube_channel")
//	private String youtubeChannel;
//
//	@Column(name="hobby")
//	private String hobby;
//
//	// constructors
//
//	// getters / setters
//}
//
//3.
//
//@Entity
//@Table(name="instructor_detail")
//public class Instructor {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;
//
//	@Column(name="first_name")
//	private String firstName;
//
//	@Column(name="last_name")
//	private String last_name;
//
//	@Column(name="email")
//	private String email;
//
//	// constructors
//
//	// getters / setters
//}
//
//Map the instructor to the table, Now here we really just have 2 independent classes. now we have an instructor detail class and an instructor class, but they're not linked. They're not mapped together and we need take care of that. So what we can do make use of it @OneToOne annotation
//So this is basically allow us to instructor detail and our instructor class together 
//
//@OneToOne
//@JoinColumn(name="instructor_detail_id")
//private InstructorDetail instructorDetail;
//
//So that's a new annotation for our OneToOne relationship. Then we need to do tell them how to hook this up. So we're basically saying, Hey Hibernate to instructor detail we have a joint column called instructor detail id. That's the instructor detail ID that's defined in this instructor table. Then use the annotation Hibernate can got off and use the FK, find the instructor detail record and load the data accordingly. Hibernate will do in background And then in memory, you'll have an instructor object along with its related entity, the instructor detail and it's all handled by Hibernate And the ref here for this @OneToOne and the JoinColumn.
//
//Entity Lifecycle
//Check Tab
//
//Because we need to learn more about cascade types. But before we can really understand cascading types we need to learn a bit more about the entity life cycle. Basically set of states that a hybrid entity can go through when you're using it in your applicaiton. 
//
//Operations							Description
//--------------------------------------------------------
//Detach								If entity is detached, it's not associated with a Hibernate session
//Merge								If instance is detached from session, then merge will reattch to session
//Persist								Transitions new instance to managed state. Next flush / commit will save in db.
//Remove								Transisions managed entity to be removed. Next flush / commit will delete from db.
//Refresh								Reload / synch object with data from db. Prevents stale data
//
//So If we have this state where an object is a new object we either call the new keyword or it's transient then what we'll do is we can actually save it or persist it. like a persistent object or a managed object. If you want to rollback we could do a rollback or create a new object and its the New/Transient state. If you want to sync the object from the DB, then we can do a refresh 
//
//Next if we have a persistent object we can do a commit rollback or close and that'll actually make that object detached so it's not associated with a given Hibernate session. if we'd like to reattach that object to the hibernate session, then we simply get a ref to that object and we simply do a merge on it. 
//
//If we do a delete or remove then the object is now in the removed state. we can also do a rollback or persist to actually make it available and make it back into a manage state. we can do a commit on a removed object.So now it's removed from the DB and now it's just in a transient state. and then we could say rollback so that'll take the object and move it back to the detached state. 
//
//Cascade delete
//when you delete the instructor and also appropriate on row instructor detail row, It'll cascade the delete. Apply the same operation to the given related entity. And then related entity in this case is the instructor detail.
//
//@OneToOne - Cascade Types
//
//Cascade types					Description
//PERSIST 						If entity is persisted/saved, related entity will also be persisted
//Removed							If entity is removed / deleted, related entity will also be deleted
//REFRESH							If entity is refereshed, related entity will also be refreshed
//DETACH 							If entity is detached (not associated w/ session), then related entity will also be detached
//MERGE 							if entity is merged, then related entity will also be merged
//ALL 							All of above cascade types
//
//Configure Cascade Type
//
//@OneToOne(cascade=CascadeType.ALL)	
//by defualt no operations are cascaded, if you dont specify cascade then none of the operations will cascade. So you have to explicitly ref a given cascade type that you like to apply for your given relationship. 
//
//Configure Multiple Cascade Types
//
//This is how you can configure multiple cascade types, If you want finer grain control over which cascade types are applied because you may not want all 
//
//@OneToOne(cascade={CascadeType.DETACH
//					CascadeType.MERGE
//					CascadeType.PERSIST
//					CascadeType.REFRESH
//					CascadeType.REMOVE})
//
//4.
//
//public static void main(String[] args){
//	...
//	// create the objects
//	Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//	InstructorDetail tempInstructorDetail =
//		new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
//
//	// associate the objects
//	tempInstructor.setInstructorDetail(tempInstructorDetail);
//
//	// start a transaction
//	session.beginTransaction();
//
//	session.save(tempInstructor);
//
//	// commit transaction
//	session.getTransaction().commit();
//}


public class CreateDemo {

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
			// get instructor by PK /id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: "+tempInstructor);
			
			// delete the instructor
			if(tempInstructor !=  null) {
				System.out.println("Deleting: "+tempInstructor);
				
				// Note: will also delete associated "details" object 
				// because of Cascade.ALL
				//
				session.delete(tempInstructor);
			}

			System.out.println("Saving instructor: "+tempInstructor);

			// commit transaction
			session.getTransaction().commit();
		}	 finally {
			factory.close();
		}

	}

}
