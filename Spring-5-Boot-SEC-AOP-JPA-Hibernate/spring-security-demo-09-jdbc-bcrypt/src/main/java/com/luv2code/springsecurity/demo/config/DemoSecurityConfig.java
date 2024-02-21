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

//## Spring Security Password Encryption
//
//### Password Storage
//* So far, our user passwords are stored in plaintext ... yikes!
//* Ok for getting started no for production / not for ready for projects
//
//### Password Storage - Best Practice
//
//* The best practice is store passwords in an encrypted format ( So if our databases were hacked, the hackers wouldb't be able to figure out these passwords, wouldn't be able to figure out the plain text version of these passwords because they are encrypted. )
//
//### Spring Security Team Recommendation
//
//* Spring Security recommends using the popular bcrypt algorithm
//* bcrypt
//	* Performs one-way encrypted hashing
//	* Adds a random salt to the password for additional protection
//	* Includes support to default brute force attacks
//
//### Bcrypt Additional Information
//
//* Why you should use bcrypt to hash passwords
//	www.luv2code.com/why-bcrypt
//* Detailed bcrypt algorithm analysis
//	www.luv2code.com/bcrypt-wiki-page
//* Password hashing - Best Practices
//	www.luv2code.com/password-hashing-best-practices
//
//### How to Get a Bcrypt password
//
//* You have a plaintext password and you want to encrypt using bcrypt
//
//	* Option 1: Use a website utility to perform the encryption
//	* Option 2: Write Java code to perform the encryption
//
//### How to Get a Bcrypt password - Website
//
//* Visit: www.luv2code.com/generate-bcrypt-password
//* Enter your plaintext password
//* The website will generate a bcrypt password for you
//
//* Now one important thing to note is that multiple runs will generate a different password due to the random password salting. You can start with the same plain text password test123, but if you hit calculate mutiple times, you'll actually get a different generated password due to athe random salting, Effectively salting is random bits of data that will be added to the password to make it unique.
//
//### Development Process 
//
//1. Run SQL Script that contains encrypted passwords
//	A Modify DDL for password field, length should be 68
//2. Modify database properties file to point to new database schema
//
//`That's! No need to change Java code`
//
//### Spring Security Password Storage
//
//* In Spring Security 5, passwords are stored using a sprcific format
//https://www.bcryptcalculator.com/encode
//
//{bcrypt}encodedPassword
//
//john -> $2a$10$xOLkYhGPtMKtIUw9GkYsEOy6QGFKTxNyTYzX3Fk0tKjdzMjgLsYt2
//
//* So here we'll have Bcrypt, and so this kind of maps of the actual ID that we have in our database table for password. And then for the encoded password that'll be the actual generated or hashed value that we retrieve from that website, or that we created using Java code. Now one thing that's really important here about this password column, it must be at least 68 characters wide, because for Bcrypt in curly braces, that's eight characters, and then the encoded password is 60 characters. When you use Bcrypt your encoded password or your encrypted password is always 60 characters in length, regardless of the input of the plain text. 
//
//### Modify DDL for Password Field
//
//```sql
//	CREATE TABLE `users` (
//		`username` varchar(50) NOT NUL,
//		`password` char(68) NOT NULL,
//		`enabled` tinyint(1) NOT NULL,
//
//		PRIMARY KEY (`username`)
//	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
//```
//
//#### Step 1. Run SQL Script that contains encrypted passwords
//
//```sql
//-- We simply add in the encrypted passwords for those users. 
//INSERT INTO `users`
//VALUES
//('john', '{bcrypt}$2a$10$A/frCBLjC7VmiwAaj.YJM.KZxSFmLgdlwdy2aWDD7JELAJfCfcts2', 1),
//('mary', '{bcrypt}$2a$10$A/frCBLjC7VmiwAaj.YJM.KZxSFmLgdlwdy2aWDD7JELAJfCfcts2', 1),
//('susan', '{bcrypt}$2a$10$A/frCBLjC7VmiwAaj.YJM.KZxSFmLgdlwdy2aWDD7JELAJfCfcts2', 1);
//```
//
//#### Step 2. Modify database properties file to point to new database schema
//
//```json
//	jdbc.url=jdbc:mysql://localhost:3306/spring_security_demo_bcrypt?useSSL=false
//
//```
//
//### Spring Security Login Process
//
//-> Check Tab
//
//* is just kind of give you a quick behind the scenes tour about some of the Spring Security login process. So we have our login form here, we have our database that has encrypted passwords. We have these Spring Secuirty filters in place. They're usually going to enter their plain text password on the form and hit login, so then behind the scenes the Spring Security filters will read this information and perform some operations on it, using JDBC authentication.
//
//1. Retrieve password from db for the user
//2. Read the encoding algorithm id (bcrypt etc)
//3. For case of bcrypt, encrypt plaintext password from login form(using salt from db password)
//4. Compare encrypted password from login from WITH encrypted password from db
//5. If there is a match, login successful
//6. If no match, login NOT successful
//
//* NOTE: The password from db is NEVER decrypted, Because bcrypt is a one-way encryption algorithm So never grab the password from the database and decrypt it and have it as plain text, because algo doesn't support It's only a one-way alogirthm. So the process read that plain text password from the user form, you encrypted it, and then you compare those 2 encrypted values. The one from the form and then the one that you read from the database. 
// New password fun123, crazy123


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
