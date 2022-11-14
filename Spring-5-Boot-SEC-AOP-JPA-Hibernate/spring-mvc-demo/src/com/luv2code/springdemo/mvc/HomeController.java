package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//20. What is Spring MVC?
//
//* Framework for building web application in Java
//* Based on Model-View-Controller design pattern
//* Leverages features of the Core Spring Framework (IoC, DI)
//
//Check on Tab Spring MVC
//Basically incoming req coming from the browser, It'll encounter the Spring MVC front controller. This person will actually delegate the req off to a controller code.
//
//This controller code that you create that contains your business logic 
//you basically create a modal and you send the model back to the front controller, FC pass a model over to your view template. VT like HTML page or JSP page that will take the data and then render a response to the browser, that's kind of the big picture of MVC framwork.
//
//Spring MVC Benefits
//
//* The Spring way of building web app UIs in Java
//* Leverage a set of reusable UI Components 
//* Help manage application state for web req (like session and application tracking) 
//* Process form data: validation , conversion etc (and you can also process your form data, validation form data converion, so on and so forth)
//* Flexible configuration for the view Layer (u could also use other view layer like thymeleaf, velocity, or FreeMarker, Groovy)
//
//Components of a Spring MVC Application
//* A set of web pages to layout UI Components
//* A collection of Spring beans (controllers, services, etc...)
//* Spring configuration(XML, Annotations or Java)
//
//Spring MVC Front Controller
//
//* Front controller known as DispatcherServlet
//	* Part of the Spring Framework
//	* Already developed by  Spring Dev Team
//
//* You will create
//	* Model objects (orange)
//	* View templates (dark green)
//	* Controller classes (yellow)
//
//this FC is the part of the spring framework It's already developed by the spring development team. So you don't have to create this This is part of the spring jar files that you download. So give to you so out of the box, you have this front controller. 
//
//with this FC actully delegate the req to some other objects So as a developer you will create the model, view, and the controller 
//M -> contain data 
//V -> Jsp page or View page to actually render the data 
//C -> That's actual business logic or your processing logic.
//
//Controller
//* Code created by developer
//* Contains your business logic
//	* Handle the req
//	* Store/retrieve data (db, web service...)
//	* Place data in model
//* Send to appropriated view template
//
//Model
//* Model: contains your data
//* Store/retrieve data via backend systems
//	* database, web service, etc...
//	* Use a Spring bean if you like
//
//* Place your data in the model
//	* Data can be any java object/collection
//
//View Template
//
//* Spring MVC is flexible
//	* Supports many view templates
//
//* Most common is JSP + JSTL
//* Developer creates a page
//	* Displays data
//
//So this model data comes over to you view template, and then your JSP page can read that model data and display it. 
//Ex you have the list student data, product, then we are going to display that product list or that student list. 
//
//Dev Environment
//	* Apache Tomcat
//	* Eclipse (Java EE Version)
//	* Connected Eclipse to Tomcat
//
//Tomcat Version
//* New Version of Tomcat 10 was released to support Jakarta EE 9
//	* Renamed packages: javax.* to jakarta.*
//	* This is breaking change for Java EE apps
//
//* Spring 5 currently does not support the new package renaming Jakarta EE 9
//* As a result, Spring 5 does not currently work on Tomcat 10
//* Use Tomcat 9 for your Spring 5 apps
//
//Additional Things To Do
//1. Download Spring MVC source code
//2. Download latest Spring JAR files from Spring website
//
//21. Spring MVC Config
//
//Add Configurations to file: WEB-INF/web.xml
//
//1. Configure Spring MVC Dispatcher Servlet
//2. Set up URL mappings to spring MVC Dispatcher Servlet
//
//Add Configuration to file: WEB-INF/spring-mvc-demo-servlet.xml
//
//3. Add support for Spring component scanning
//4. Add support for conversion, formatting and validation
//5. Configure Spring MVC View Resolver
//
//1. web.xml
//
//<web-app>
//	<servlet>
//		<servlet-name>dispatcher</servlet-name>
//		<servlet-class>org.springfromework.web.servlet.DispatcherServlet</servlet-class>
//		<init-param>
//			<param-name>contextConfigLocation</param-name>
//			<param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
//		</init-param>
//		<load-on-startup>1</load-on-startup>
//	</servlet>
//	2. <servlet-mapping>
//		<servlet-name>dispatcher</servlet-name>
//		<url-pattern>/<url-patter>
//	</servlet-mapping>
//</web-app>
//
//3. spring-mvc-demo-servlet.xml
//<beans>
//	<!-- Step 3: Add support for component scanning -->
//	<context:component-scan base-package="com.luv2code.springdemo" />
//
//	<!-- Step 5: Add support for conversion, formatting and validation support ->
//	<mvc:annotation-driven />
//	<bean
//		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//		<property name="prefix" value="/WEB-INF/view/" />
//		<property name="suffix" value=".jsp" />
//	</bean>
//
//</beans>
//
//you simply add context component scan 
//View Resolver Configs - Explianed
//
//* When your app provides a "view" name, Spring MVC will
//	* prepend the prefix
//	* append the suffix
//
//Development Process
//1. Create Controller class
//2. Define Controller method
//3. Add Request Mapping to Controller method
//4. Return View Name
//5. Develop View Page
//
//1. Annotation class with @Controller
//	*@Controller inherits from @Component ... supporting scanning
//
//	@Controller
//	public class HomeController {
//
//	}
//@Controller, really gonna specialize component its gonna support WEB MVC
//When Spring does its component scanning they also pick up @Controller becu they inherit or extend from @Component.
//
//2. Define Controller method
//
//@Controller
//public class HomeController {
//	public String showMyPage() {
//
//	}
//}
//// this method name very flexible you can use any method name, you can actually pass any number of parameters like req parameters, session objects, 
//
//3.
//@Controller
//public class HomeController {
//	@RequestMapping("/")
//	public String showMyPage() {
//	4. return "main-menu"
//	}
//}
//
//// we need to add the req mapping, basically we need a some kind of web req to this given method. And we do this with an annotation @RequestMapping, actual path wanna map, So in my example i simply wanna map on the root, In this req mapping get all kind of requests get post so on and so forth.
//
//Inside of the method actually return the view name "main-menu"; thats the name of the view, now remember a magic that gonna happen on the background, Spring actually use info from the configuration file will actually find the view page 
//
//5. <html><body>Spring MVC Demo - Page</body></html>
//

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}

//How Does Component Scan work your package Names are different!
//
//Spring will recursively scan for components starting at the base package: "com.luv2code.springdemo"
//
//When I say "recursive", it means that Spring will start at the base package and scan all sub packages.
//The package com.luv2code.springdemo.mvc is a sub package because of naming structure, just like folders on a file system



