package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;

//# Spring Security - Add JDBC Database Authentication
//
//## Overview - Defining Database Schema
//
//* We'll learn how to use Spring Security with user accounts stored in the database. 
//
//### Database Access
//
//* So far, our user accounts were hard coded in Java source code 
//* We want to add database access (this is an advanced feature for SS)
//
//### Recall Our User Roles
//john -> test123 -> EMPLOYEE
//mary -> test123 -> EMPLOYEE, MANAGER
//susan -> test123 -> EMPLOYEE, ADMIN
//
//### Database Support in Spring Security
//
//-> Check Tab
//
//* Spring Security can read user account info from database 
//* By default, you have to follow Spring Security's predefined table schemas 
//
//* Spring Security includes all of the JDBC code to actually read information from the database. So there's very little Java code you have to write as far as JDBC code for reading information from the database, all you have to do is simply setup the configuration, create the appropriate tables, and Spring Security will do all of the heavy lifting for you in the background.
//
//### Customize Database Access with Spring Security
//
//* Can also customize the table schemas
//* Useful if you have custom tables specific to your project / custom
//* You will be responsible for developing the code to access the data 
//	* JDBC, Hibernate etc ... (low level JDBC code)
//
//### Database Suppport in Spring Security
//
//* Follow Spring Security's predefined table schemas, (That will give us all the functionality and all of the code for hooking into the actual database, and this is all given to you out of the box.)
//
//### Development Process
//
//1. Develop SQL Script to setup databse tables
//2. Add database support to Maven POM file
//3. Create JDBC properties file
//4. Define DataSource in Spring Configuration
//5. Update Spring Security Configuration to use JDBC
//
//
//### Default Spring Security Database Schema
//
//* Spring Security has a default database schema, so you need to provide 2 tables, one called users, and one called authorities. And you have to use these exact table names, and also these tables need to have these columns: username, password and enabled for users, and authorities is the username and authority. You need to have the exact same table names and columns as shown here.
//* And also, when you see the word authorities here, authorities is the same thing, or loosely the same thing as roles. So, you see authorities, just think roles. 
//
//#### Step 1. Develop SQL Script to setup databse tables
//
//```sql
//	CREATE TABLE `users` (
//		`username` varchar(50) NOT NULL,
//		`password` varchar(50) NOT NULL,
//		`enabled` tinyint(1) NOT NULL,
//		-- enabled = 1, user can log in
//		-- enabled = 0, user cannot log in
//		PRIMARY KEY (`username`)
//	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
//	-- So again, the exact same table name of users and the exact same columns, username, password and enabled.
//```
//
//##### Spring Security Password Storage
//
//* In Spring Security 5, passwords are stored using a specific format (so in curly braces you give the actual ID and then you have the encoded password. So the idea is the encoding algorithm that's being used for this password.)
//```sql
//	{id}encodedPassword
//```
//
//noop -> Plain text passwords (no encryption, no hashing, no nothing.)
//bcrypt -> BCrypt password hashing (So basically one-way hashing, BCrypt Algorithm, BCrypt is a very popular hashing algorithm that's used now,)
//
//```sql
//	INSERT INTO `users`
//	VALUES 
//	('john', '{noop}test123', 1),
//	('mary', '{noop}test123', 1),
//	('susan', '{noop}test123', 1),
//```
//
//```sql
//	CREATE TABLE `authorities` (
//		`username` varchar(50) NOT NULL
//		`authority` varchar(50) NOT NULL
//	UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
//
//	CONSTRAINT `authorities_idx_1`
//	FOREIGN KEY (`username`)
//	REFERENCES `users` (`username`)
//	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
//```
//
//* And that'll basically create the authorities table, and again remember, the authorities table is the same thing as roles. and then we simply do an INSERT INTO 'authorities', and again, authorities, same as roles. Then we'll go ahead and do an INSERT here for john.
//* And remember again, internally Spring Security uses the "ROLE_" prefix for the actual role entries. 
//
//```sql
//	INSERT INTO `authorities`
//	VALUES
//	('john', 'ROLE_EMPLOYEE'),
//	('mary', 'ROLE_EMPLOYEE'),
//	('mary', 'ROLE_MANAGER'),
//	('susan', 'ROLE_EMPLOYEE'),
//	('susan', 'ROLE_ADMIN')
//```
//
//#### Step 2. Add database support to Maven POM file
//
//```xml
//	<!-- MySQL -->
//	<dependency>
//		<groupId>mysql</groupId>
//		<artifactId>mysql-connector-java</artifactId>
//		<version>5.1.45</version>
//	</dependency>
//	<dependency>
//		<groupId>com.mchange</groupId>
//		<artifactId>c3p0</artifactId>
//		<version>0.9.5.2</version>
//	</dependency>
//```
//* Now moving ahead here to step 2, we need to add database support to our Maven POM files. So we need to give a reference here to our JDBC driver, so we're using MySQL in this example, so we give the MySQL group id artifactId inversion. 
//* And we're also gonna make use of connection pooling. So we're gonna use a C3P0, and we give the appropriate Maven coordinates for that, com.mchange, c3p0, and the actual version number. When we need to update our Maven POM file. 
//
//#### Step 3. Create JDBC properties file
//
//```json
//	#
//	# JDBC connection properties
//	#
//	jdbc.drive=com.mysql.jdbc.Driver
//	jdbc.url=jdbc:mysql://localhost:3306/spring_security_demo?useSSL=fale
//	jdbc.user=springstudent
//	jdbc.password=springstudent
//	#
//	# Connection pool properties
//	#
//	connection.pool.initialPoolSize=5
//	connection.pool.minPoolSize=5
//	connection.pool.maxPoolSize=20
//	connection.pool.maxIdleTime=3000
//```
//
//* Now we have step three of creating our JDBC properties file,and then we basically put our info in a props file to tell Spring Security how to connect to our database. So we give all the JDBC connection properties, and then we also give the connection pool properties on how to manage the pool, the minimum size, the max size, and all that good stuff. We'll place this info into a properties file, and lets you read this properties file in our Java configuration. 
//
//#### Step 4. Define DataSource in Spring Configuration
//
//* So defining a DataSource in our Spring Configuration. Now what we need to do is actually go through and actually log same information. So for sanity's sake, I like to always log URL and user ID just to make sure we're reading the data from that props file. So here i'm gonna log all that info, and i'll say: jdbc.url is the env.getProperty jdbc.url, and i'll do a similar thing for jdbc.user, just to read the configuration, just to log into my log file, just so I know that i'm actually reading that data. 
//```java
//	// for sanity's sake, let's log url and user ... just to make sure we are reading the data
//	logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.url"));
//	logger.info(">>>> jdbc.user=" + env.getProperty("jdbc.user"));
//
//	// set database connection props
//	securityDataSource.setJdbcUrl(env.getProperty('jdbc.url'));
//	securityDataSource.setUser(env.getProperty('jdbc.user'));
//	securityDataSource.setPassword(env.getProperty('jdbc.password'));
//```
//
//
//* I'll tell ya, you can waste a lot of time if you're not reading the correct file. So now let's go ahead and set the database connection property. So with the security data source, I go ahead and set the jdbc.url. I just simply read that property for jdbc.url and I just repeat the process for the setting the user ID, and also for setting the password. 
//```java
//	// set connection pool props
//	securityDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")))
//```
//
//
//* Then i'll simply go through and set the connection pool properties here. I'll do a security data source, I need to use this Integer.parseInt to convert the string to an int and, then set the value. I have to go through all of these steps because we're using pure Java Configuration, so when we use pure Java Config, we have do a lot of the coding on our own. If we were simply using something like XML Config, It'll be much simpler and easier. But this is the process for doing it using pure Java Config, No XML. 
//
//```java
//	securityDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")))
//	securityDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")))
//	securityDataSource.setMaxIdlePoolSize(Integer.parseInt(env.getProperty("connection.pool.maxIdlePoolSize")))
//```
//
//* This is for the connection pool properties so I'll basically just kinda copy paste this, or do a similar thing for all of the other properties that we have here. I read all the data from that configuration, and then setting the data accordingly on the security data source. And then finally, at the end once I'm all done, I simply return securityDataSource and that's it.
//* So, the securityDataSource has been created, we went through and set all the properties, set all the configs, it's all set up ready to go, and we can use it in our Spring application. 
//
//#### Step 5. Update Spring Security Configuration to use JDBC
//
//```java
//	@Configuration
//	@EnableWebSecurity
//	public class DemoSecurityConfig extends WebSecurityConfigureAdapter {
//		// So, in our demo security config, we're actually gonna inject that data source that we just configured. So I have @autowired, private DataSource, securityDataSource. So that bean's already been created in the previous set of slides, now I can use it here in my demo security config. 
//		@Autowired
//		private DataSource securityDataSource;
//		
//		// So when I override that configure method with that auth manager builder, then I say: auth.jdbcAuthentication.  So i'm telling Spring Security to use JDBC authentication, and then I provide my data source: securityDataSource. 
//		@Override
//		protected void configure(AuthenticationManagerBuilder auth)throws Exception {
//			// And the really nice thing here is that, we're no longer hard-coding users, we're actually reading users from the database. So Spring Security knows about our database tables cause we set all of that up in the configuration, and Spring Security with handle all of the low level work of reading the user, passwords, roles, and so on.from our database their table schema, and we're using theire actual table names and theire actual column names. So spring security will do a lot of the heavy lifting for us in the background. 
//			auth.jdbcAuthentication().dataSource(securityDataSource);
//		}
//	}
//```



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// add our users for in memory authentication
//		UserBuilder users = User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication()
//			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
//			.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
		// use jdbc authentication ... oh yeah!!!
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	// Now gonna override the methods HTTP security,

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.anyRequest().authenticated()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
				.logout().permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
}
