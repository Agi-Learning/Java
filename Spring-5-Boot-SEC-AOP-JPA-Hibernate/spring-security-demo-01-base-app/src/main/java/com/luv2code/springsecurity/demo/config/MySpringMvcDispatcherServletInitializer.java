package com.luv2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//## Spring Security
//
//### Overview
//#### You will learn how to
//
//* Secure Spring MVC Web Apps
//* Develop login pages (default and custom)
//* Define users and roles with simple authentication
//* Protect URLs based on role
//* Use JSP tags to hide/show content based on role
//* Store users, passwords and roles in DB (plain-text->encrypted)
//
//#### Practical Results
//
//* Cover the most common Spring Security tasks that you will need on daily projects
//* Not an A to Z reference... for that you can see Spring Security Reference Manual
//	* http://www.luv2code.com/spring-security-reference-manual
//
//#### Spring Security Model
//
//* Spring Security defines a frameworks for security
//* Implemented using Servlet filters in the background
//* Two methods of securing a Web app: declarative and programmatic
//
//#### Spring Security with Servlet Filters
//
//* Servlet Filters are used to pre-process / post-process web requests
//* Servlet Filters can route web requests based on security logic
//* Spring provides a bulk of security functionality with servlet filters 
//
//#### Spring Security Overview
//Check Tab ->
//
//* Browser top secert info and give the results now this  were security comes in a play. So these basically security thing intercept the request pre-process see access the protected web resource So look at your application security configuration and also take look at the users passwords and rows that are new database to see if the users autheticated and also there authorized accesses web resource. in that how happens in the background.
//
//### Sprin Security in Action
//Check Tab ->
//
//* Yes, then, "Is the user authenticated? " not then sent to them to the login form. In the login form then take the user ID and password and authenticate it. So, check to see if this user ID and password is valid based on the information we have stored in our system. So then if they pass that test, so they're authenticated, So then we check to see, is the user authorized? So, just like a your job, right, you have a security badge, or at your university, you have a security badge to get into the main building, however, you may not be able to access all of our rooms in a building it all depends on your access level or your authorization role. 
//* So just because you have a good user ID and password, that doesn't mean you have access to everything. There's still additional levels of security in place, and Spring has support with that using security roles. So if you don't have given roles let's say access denied, or if you do have the given role, and then you can access this secure site. So basically, the security here is in place to keep the bad guys out, and allow the good folks inside. 
//
//#### Security Concepts
//
//* Authentication
//	* Check user id and password with credentials stored in app / db
//
//* Authorization
//	* Check to see if user has an authorized role
//
//#### Declarative Security
//
//* Define application's security constraints in configuration
//	* All Java config (@Configuration, no xml)
//	* or Spring XML config
//* Provides separation of concerns between application code and security 
//
//#### Programmatic Security
//
//* Spring Security provides an API for custom application coding
//* Provides greater customization for sepcific app requirements
//
//#### Different Login Methods
//
//* HTTP Basic Authentication
//* Default login form 
//	* Spring Security provides a default login form 
//* Custom login form
//	* Your own look-and-feel, HTML + CSS
//
//#### Authentication and Authorization
//
//* In-memory
//* JDBC
//* LDAP
//* Custom / Pluggable
//* others
//
//	* We will cover password storage in DB as plain-text AND encrypted
//	-> User
//	-> Passwords
//	-> Roles
//
//
//### Demo
//#### Our Example
//
//* So basically for our example, we're gonna have a login page, a custom login page and then we'll actually have role of employee From there, we'll have a special section of pages for the Leadership retreat, only for the role of manager. And then we'll also have another page, Admin Holiday curse for the role of admin. So we have special pages that are only available to certain users or certain roles, and we'll configure that using Spring Security. 
//
//### All Java Configuration
//
//#### Spring MVC App - Java Config
//
//##### Java Configuration
//
//* Instead of configuring Spring MVC app using XML 
//	* web.xml
//	* spring-mvc-demo-servlet.xml
//* Configure the Spring MVC app with Java code (no xml)
//
//##### Development Process
//
//1. Add Maven dependencies for Spring MVC Web App
//2. Create Spring App Configuration (@Configuration)
//3. Create Spring Dispatcher Servlet Initializer
//4. Develop our Spring controller
//5. Develop our JSP view page
//
//###### Spep 1: Add Maven dependencies for Spring MVC Web App
//
//* spring-webmvc, jstl, javax.servlet-api, javax.servlet.jsp-api So these are all artifact id are need to add given pom.xml file.
//
//-> pom.xml
//```xml
//	<!-- Spring MVC support -->
//	<dependency>
//		<groupId>org.springframework</groupId>
//		<artifactId>spring-webmvc</artifactId>
//		<version>...</version>
//	</dependency>
//
//	<!-- Servlet, JSP and JSTL support -->
//	<dependency>
//		<groupId>javax.servlet</groupId>
//		<artifactId>javax.servlet-api</artifactId>
//		<version>...</version>
//	</dependency>
//
//	<dependency>
//		<groupId>javax.servlet.jsp</groupId>
//		<artifactId>javax.servlet.jsp-api</artifactId>
//		<version>...</version>
//	</dependency>
//
//	<dependency>
//		<groupId>javax.servlet</groupId>
//		<artifactId>jstl</artifactId>
//		<version>...</version>
//	</dependency>
//```
//
//* Will load all supporting dependencies: spring-core, logging etc ... Also add support for Servlet, JSP and JSTL
//
//###### Customize Maven Build
//
//-> pom.xml
//
//```xml
//	<build>
//		<pluginManagement>
//			<plugins>
//				
//				<!-- Need to customize Maven build Since we are not using web.xml -->
//				<plugin>
//					<!-- Add Maven coordinates (GAV) for: maven-war-plugin -->
//					<groupId>org.apache.maven.plugins</groupId>
//					<artifactId>maven.war.plugin</artifactId>
//					<version>3.2.0</version>
//				</plugin>
//
//			</plugins>
//		</pluginManagement>
//	</build>
//```
//
//###### XML config to Java config
//
//* Use 
//	"Spring"
//	@Configuration
//
//* Use
//	Spring Dispatcher
//	Servlet Initializer
//
//* No XML!
//
//###### Flash Back to XML config (the old way)
//
//-> spring-mvc-demo-servlet.xml
//
//```xml
//	<beans>
//		<!-- Add support for component scanning -->
//		<context:component-scan base-package="com.luv2code.springdemo" />
//		<!-- Add support for conversation, formatting and validation support -->
//		<mvc:annotation-driven />
//
//		<!-- Define Spring MVC view resolver -->
//		<bean
//			class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//			<property name="prefix" value="/WEB-INF/view" />
//			<property name="suffix" value=".jsp" />
//		</bean>
//
//	</beans>
//```
//
//###### Enabling the MVC Java Config
//
//	"@EnableWebMvc"
//* Provides similar support to <mvc:annotation-driven /> in XML.
//* Adds conversion, formatting and validation support
//* Processing of @Controller classes and @RequestMapping etx ... methods
//
//
//###### Spep 2: Create Spring App Configuration
//
//-> DemoAppConfig.java
//
//```java
//	@Configuration
//	@EnableWebMvc
//	@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
//	public class DemoAppConfig {
//		// define a bean for ViewResolver
//
//		@Bean
//		public ViewResolver viewResolver() {
//			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//			viewResolver.setPrefix("/WEB-INF/view/");
//			viewResolver.setSuffix(".jsp");
//
//			return viewResolver;
//		}
//	}
//```
//###### View Resolver Configs - Explained
//
//```java
//	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//	viewResolver.setPrefix("/WEB-INF/view/");
//	viewResolver.setSuffix(".jsp");
//```
//
//* Basically this can apply map for the view page Whether "/WEB-INF/view/show-student-list.jsp" 
//
//###### Flash Back to XML config (the old way)
//
//-> web.xml
//
//```xml
//	<web-app>
//		<servlet>
//			<servlet-name>dispatcher</servlet-name>
//			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//			<init-param>
//				<param-name>contextConfigLocation</param-name>
//				<param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
//			</init-param>
//			<load-on-startup>1</load-on-startup>
//		</servlet>
//		<servlet-mapping>
//			<servlet-name>dispatcher</servlet-name>
//			<url-pattern>/</url-pattern>
//		</servlet-mapping>
//	</web-app>
//```
//
//
//###### Web App Initializer
//
//* Spring MVC provides support for web app initialization
//* Makes sure your code is automatically detected
//* Your code is used to initialize the servlet container 
//
//"AbstractAnnotationConfigDispatcherServletInitializer"
//
//* Your TODO list 
//	* Extend this abstract base class
//	* Override required methods
//	* Specify servlet mapping and location of your app config
//
//-> MySpringMvcDispatcherServletInitializer.java
//```java
//	// We basically create a class that extends off of that base class, and then we simply overwrite of the methods of get root config classes, 
//	import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//	public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//		@Override
//		protected Class<?>[] getRootConfigClasses(){
//			// TODO Auto-generated method stub
//			return null;
//		}
//		// We'll override the get servlet config classes, this'll actaully point to the config class that we created in step 2 in one of our previous slides. 
//		@Override
//		protected Class<?>[] getServletConfigClasses() {
//			return new Class[] { DemoAppConfig.class };
//		}
//		// And then we'll also setup our servlet mapping. So we'll have a string of just slash as our servlet mapping Now let's kind of map this with the old xml file. that we're replacing so this servlet config class, that basically hooks into the dispatcher servlet and at the bottom the servlet mappings maps to that little section here at the bottom for dispatcher servlet and tha's basically it. 
//		@Override
//		protected String[] getServletMappings() {
//			return new String[] { "/" };
//		}
//	}
//```
//
//###### Step 4: Develop our Spring Controller
//
//```java
//	@Controller
//	public class DemoController {
//		// We simply go return, We give the view name that we're actually returning. And then remember this view name goes to the web-INF/view/home.jsp based on the configuration setup in some of the previous slides. So that part is easy. 
//		@GetMapping("/")
//		public String showHome() {
//			return "home";
//		}
//	}
//```
//
//###### Step 5: Develop our JSP view page
//
//-> /WEB-INF/view/home.jsp
//
//```html
//	<!DOCTYPE html>
//	<html>
//	<body>
//		Welcome to the luv2code company hoem page!
//	</body>
//	</html>
//
//```
//
//###### Add Maven dependencies for Spring Security
//
//1. spring-security-web
//2. spring-security-config
//
//###### Spring Projects
//
//* Spring Security that's spring framework that covers the core, aop, and mvc. 
//
//* These are 2 seperate projects
//* The projects are on different release cycles
//* Version numbers between projects are generally not in sync (sigh...)
//	* Spring team is working to resolve this for future release... (but you really need to be aware of this as for as version numbers and the compatible versions that you use with Spring.  )
//
//* Common pitfall is using incompatible projects
//* Need to find compatible version (So you need to find a compatible version between Spring Framework and Spring Security, )
//
//###### Finding Compatible version
//
//* Find desired version of Spring Security in Maven Central Repo
//	* spring-security-web
//* Look at the project POM file
//	* Find supporting Spring Framework version
//
//-> Notice over on the right, This is the POM for spring-security-web, and they'll tell you which versions of Spring that this one supports, Now, notice here the Spring Security version has one number, and the actual Spring Framework version has a different number. Again, remember these versions are not in sync, but they're kinda based on each other, as far as being compatible. some make kind of research and make sure you choose the correct versions. 
//-> Again, in the future, this may get easier, may get better, but this's what we have to deal with for now. 
//
//###### Add Maven dependencies for Spring Security
//
//-> pom.xml
//```xml
//	<properties>
//		<springframework.version>5.0.2.RELEASE</springframework.version>
//		<springsecurity.version>5.0.0.RELEASE</springsecurity.version>
//	</properties>
//
//	<!-- Spring -->
//	<dependency>
//		<groupId>org.springframework</groupId>
//		<artifactId>spring-webmvc</artifactId>
//		<version>${springframework.version}</version>
//	</dependency>
//	<dependency>
//		<groupId>org.springframework.security</groupId>
//		<artifactId>spring-security-config</artifactId>
//		<version>${springsecurity.version}</version>
//	</dependency>
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
