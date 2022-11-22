package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

//32. Hibernate Identity - Primary Key
//
//Terminology
//Uniquely identifies each row in a table
//Must be a unique value
//Cannot contain NULL values
//
//MySQL - Auto Increment
//
//CREATE TABLE student (
//	id int(11) NOT NULL AUTO_INCREMENT,
//	first_name varchar(45) DEFAULT NULL,
//	last_name varchar(45) DEFAULT NULL,
//	email varchar(45) DEFAULT NULL,
//	PRIMARY KEY (id)
//)
//
//So MySQL will actually handle auto incrementing the ID every time we add a new student. And that's a really cool feature of MySQL. this given field is a primary key So this field maps to a column in the database table and that column name is id. So we basically leave it up to the database to actually generate a primary key for us. Now if you want to explicit tell to hibernate how to actually perform the generation. so you can tell hibernate
//
//use a given strategy for generating that id, So if you don't specify any thing, It'll use the appropriate strategy for that given database implementation. But here I like to be explicit and you know write it out long hand. So this is a new hibernate annotation and we say strategy=GenerationType.IDENTITY. So we're basically saying, hey the actual primary key column for this given table, that's the column that we'll use for the generation strategy. we have our ID column set to auto_increment, and we leave it up to MySQL to handle the auto increment for us. 
//@GeneratedValue(strategy=GenerationType.IDENTITY);
//
//ID Generation Strategies
//
//Name 							Description
//GenerationType.AUTO   			Pick an appropriate strategy for the particular DB
//GenerationType.IDENTITY			Assign primary keys using DB identity column
//GenerationType.SEQUENCE			Assign primary keys using a DB sequence
//GenerationType.TABLE 			Assign primary keys using an underlying DB table to e                               ensure uniqueness
//
//Bonus
//* You can define your own CUSTOM generation strategy :-)
//* Create implementation of org.hebernate.id.IdentifierGenerator
//* Override the method: public Serializable generate(...)
//
//Generate our own ID using our own custom business logic, you can create own generateor 
//
//Always generate unique value
//Work in high-volume, multi-threaded environment
//if using server clusters, always generate unique value
//
//make use of a cluster or a farm of servers, you're gonna make sure that this generator will create a unique value in a clustered environment. 


public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// create 3 students object
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
			// start transaction
			session.beginTransaction();

			// save the student
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
