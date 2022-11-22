package com.luv2code.hibernate.demo;
//Hibernate Advanced Mappings Overview
//
//Advanced mappings
//In the DB, you most likely will have
//	* Multiple Tables
//	* Relationships between Tables
//
//Need to model this with Hibernate
//
//* One-to-One
//* One-to-Many, Many-to-One
//* Many-to-Many
//
//One-to-One Mapping
//* An instructor can have an "instructor detail" entity
//	* Similar to an "instructor profile"
//	Instructor ------------> Instructor Details
//
//So The Instructor have basic info like their first name, last name, and email. instructor detail have more profile-specific info, like their YouTube channel, their hobby, their linkedIn channel, their Twitter handle, their Facebook page, so on and so forth. Just more dails about a given instructor.
//
//The key here is that this info is in 2 separate tables. 
//
//One-to-Many Mapping
//* An instructor can have many courses
//
//					------> Course
//					------> Course
//instructor ----->	------> Course
//					------> Course
//					------> Course
//
//So an instructor can have many courses, So we have an instructor and then multiple courses out here that are authored or created by that instuctor. So this is the classic one-to-many mapping. 
//So many to one mapping so inverse, opposite of what we have here with the one-to-many mapping.
//
//Many-to-Many Mapping
//* A course can have many students
//* A student can have many courses
//
//Course	----->						------> Student
//Course	----->						------> Student
//Course 	----->		------> 		------> Student
//Course	----->						------> Student
//Course	----->						------> Student
//
//Important Database Concepts
//
//* Primary key and foreign key
//* Cascade
//
//PK and FK
//* Primary key: identify a unique row in a table
//* Foreign key:
//	* Link tables together
//	* a field in one table that refers to PK in another table 
//
//
//So for foreign keys i have this one table called instructor, I have my normal instructor info. We also have a separate table, instructor detail, that has all of our details for that given instructor. Now what we can do this make use of the instructor detail column So this is basically a foreign key column that we set up in our instructor table. This basically has the link between the instructor and the actual instructor detail. So for myself, Darby my instructor detail ID is 100 The links over to the primary key, or the ID, in the instructor detail. That's the idea of a foreign key, links two tables together. 
//
//Cascade
//* You can cascade operations
//* Apply the same operation to related entities
//
//instructor save the operations and apply that same operation to instructor detail. To perform save an instructor It does the same operation on instructor detail, that's cascading
//
//* If we delete an instructor, we should also delete their instructor_detail
//	* This is known as "CASCADE DELETE"
//
//if you gonna perform delete an instructor then we should also delete their instructor detail, 
//
//* Cascade delete depends on the use case
//In this scenario many to many with courses and students, 
//* Should we do cascade delete here??
//So if we delete a student, should we also delete the course?  -- No Way -- 
//but you shouldn't delete the course. So it really depends on your use case and your app. But the nice thing about it is that, as a developer, you have fine grain control over config cascading and I'll show you all of that in some of the later
//
//Fetch Types: Eager vs Lazy Loading
//* When we fetch/retrieve data, should we retrieve EVERYTHING?
//	* Eager will retrieve everything one shot
//	* Lazy will retrieve on request
//
//Here I have an instructor, and an instructor also has courses. So when I retrieve the instructor object, should i get all of the courses for that instructor immediately or should i grab the courses only on request? 
//
//Uni-Directional
//
//Instructor ------------------>  Instructor Detail
//
//You have an instructor and then you actually have the instructor detail. So you start with the instructor object, you load the instructor, and then from there you can access the instructor detail. So its really a one-way relationship.
//
//Bi-Directional
//
//
//Instructor <------------------>  Instructor Detail
//
//So we can actually load the instructor detail and have a ref to the given instructor. 
//

public class HibernateAdvanced {

}
