package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

//# Spring Security - Restrict Access Based on Role
//
//## Restrict Access - Overview
//
//-> Check Tab
//* So with our ex we're going to have our login page and once we login we'll go to our Home page, and this will be restricted to only people with the role of employee. And then we'll go to another page slash leaders. This is the Leadership Retreat Page. This will only be available to users with the role of Manager. And then we'll have another link to a page, slash systems. This will be restricted to users with the role of Admin. 
//
//### Development Process
//
//1. Create supporting controller code and view pages
//2. Update user roles
//3. Restrict Access based on Roles
//
//
//#### Step 1. Create supporting controller code and view pages
//
//#### Step 2. Update user roles
//
//* So we currently have our user John, he's an employee, We're also gonna add some roles for Mary. And then also Susan will have the role of employee and admin. So remember our users can have many roles. And also, we can give any names for the user role names. Here I have employee, manager, and admin but you can give any role name that you want. Simply stay consistant throughout your application. 
//
//#### Step 3. Restrict Access based on Roles
//
//* Update your Spring Security Java configuration file (.java)
//* General syntax
//
//```java
//	// Restrict access to a given path "/systems/**", And we'll say we want the user to have a given role. So we say has role and then we actually give the role as a string. 
//	// So we want to match on any role in the list, and we simply give a comma-delimted list of roles. "ADMIN", "DEVELOPER", "VIP", "PLATINUM"
//	antMatchers(<< add path to match on>>).hasRole(<< authorized role >>);
//```
//
//##### Restrict Path to EMPLOYEE 
//
//```java
//	// So we have ant matchers ("/").hasRole. is the root or our application for role employee
//	antMatchers("/").hasRole("EMPLOYEE");
//```
//
//##### Restrict Path/leaders to MANAGER 
//
//```java
//	// so only the managers can see the leadership Retreat Page. That has a lot of good stuff only for management people.
//	antMatchers("/leaders/**").hasRole("MANAGER");
//```
//
//##### Restrict Path/systems to ADMIN 
//
//```java
//	// 
//	antMatchers("/systems/**").hasRole("ADMIN");
//```
//
//### Create a Custom Access Denied Page
//
//* So we've seen the default access denied page and it's actually pretty scary, right? 403-Forbidden, this will definitely scare a normal user of your application. So what we're gonna do is actually provide our own custom page, we'll give our own custom error message along with controlling the look-and-feel. So in our example here, we'll actually create a custom page.
//
//#### Development Process
//
//1. Configure custom page for access denied.
//2. Create supporting controller code and view page.
//
//##### Step 1. Configure custom page for access denied
//
//```java
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		...
//		// the custom page for access denied, so here we have exceptionHandling.accessDeniedPage and then you simply give the request mapping path. Now this will be used if there's an authorization error, or the user can't access a given page.
//		// Spring Security will use this request mapping path to show the user the access denied page. 
//		.exceptionHandling()
//			.accessDeniedPage("/access-denied");
//	}
//```
//
//##### Step 2. Create supporting controller code and view page
//
//* the supporting controller code and view page, well this is all plan vanilla Spring MVC. 
//

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
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
