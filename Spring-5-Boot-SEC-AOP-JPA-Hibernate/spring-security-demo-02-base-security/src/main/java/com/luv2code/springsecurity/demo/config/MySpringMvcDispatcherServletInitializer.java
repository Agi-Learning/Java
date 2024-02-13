package com.luv2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//## Development Process
//
//1. Create Spring Security Initializer
//2. Create Spring Security Configuration (@Configuration)
//3. Add users, passwords and roles
//
//
//### Spring Security Web App Initializer
//
//* Spring Security provides support for security initialization
//* Your security code is used to initialize the servlet container
//* Special class to register the Spring Security Filters
//* Your TODO list
//	* Extend this abstract base class
//	* that's it! (There is not code override, methods to override)
//
//### Step 1: Create Spring Security Initializer
//
//-> SecurityWebApplicationInitializer.java
//
//```java
//	import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//	// There's no methods to override, no other code to write. Very simple, very straightforward. And again, this's this weird, long class name. 
//	public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
//
//	}
//
//```
//
//### Step 2: Create Spring Security Configuration
//
//-> DemoSecurityConfig.java
//```java
//	import org.springframework.context.annotation.Configuration;
//	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//	@Configuration
//	@EnableWebSecurity
//	public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	}
//```
//
//
//### Step 2: Add users, passwords and roles
//
//-> DemoSecurityConfig.java
//```java
//	import org.springframework.context.annotation.Configuration;
//	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//	@Configuration
//	@EnableWebSecurity
//	public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
//		
//		@Override
//		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//			// add our users for in memory authentication
//
//			UserBuilder users = User.withDefaultPasswordEncoder();
//
//			auth.inMemoryAuthentication()
//				.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//				.withUser(users.username("mary").password("test123").roles("MANAGER"))
//				.withUser(users.username("susan").password("test123").roles("ADMIN"))
//		}
//	}
//```


public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DemoAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
