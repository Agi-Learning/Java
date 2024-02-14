package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

//# Spring Security - Adding Custom Login Form
//
//## Rename Context Roots
//
//* We're going to resolve an issue that we had in one of our previous videos. Remember when we tried to run our application we had this ugly Tomcat error that said it couldn't publish because we had multiple contexts at the same path. 
//* Basically on Tomcat go ahead and select both of your apps, and go ahead and remove them from the system. And so we'll actually update our project properties and give them unique names. So I'll go ahead and select this project here. 
//* I choose your project properties for web project settings. And basically what i'll need to do is change the context root, this is the problem that we had earlier. we had projects that had the same name. 
//
//### What is "Context Root"?
//
//* Well basically a context root is the root of your web application So if you have a context root of my ecommerce app, at localhost:8080/my-ecommerce-app, So it's loosely like the name of your application. But here we call it context root. 
//
//## Spring Security - Dev and Testing with New Private Window
//
//*  During Dev and Testing you may have noticed an issue... the user stays logged in!!! 
//
//* So let's just test this real quick. So our login here is john, test123, and then I'm in here, logged in a-okay, Now let's go ahead and make a small change to our code or our files. So i'll go ahead and open up home.jsp. just to kind of make a change. And I'll save this as an entry here in this file. 
//
//* Now if I were to go back to this homepage, and I do a reload here, then notice we see the changes, but the use is not forced to login, They're already logged in Why? Because the user login is based on a web browsers session, so as long as that browsers open, or that process is running, 
//
//-> "Not an issue when deployed to Production/Real-Time".
//
//* One thing I want to mention here before we go any further is that this is only an issue during Dev and Testing. So we're making some changes for code, We're testing out login, We are seeing it an issue, So only a dev issue. Once you create your code, your project, and you deploy to the servers, this is not an issue. So again, only for Dev and Testing is where you'll see this scenario, but once you deploy it to the real world, deploy to production, then this will be a non issue. 
//
//-> "Cool ... this gives us a NEW session So user is forced to login"
//
//Recap (3 solutions):
//
//1. Start new Browser
//or
//2. Quit browser and start again
//or
//3. File>New Private Window
//
//## Spring Security - Custom Login Form
//
//### Spring Security - Default Login Form
//
//* So far we've had some login work and we made use of the default login form that's given to us for free by Spring. That's good for a quick start but not really ideal. We wanna create our own custom login form where we can, kinda, control the look and feel, use our own HTML, CSS,
//
//### Development Process
//
//1. Modify Spring Security Configuration to reference custom login form
//2. Develop a Controller to show the custom login form
//3. Create custom login form
//	* HTML (CSS optional)
//	* Spring MVC form tag<form:form>
//
//#### Step 1: Modify Spring Security Configuratio
//
//-> DemoSecurityConfig.java
//```java
//	@Configuration
//	@EnableWebSecurity
//	public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
//		// We'll override a second method here, configure that takes different arguments, HTTP security. And, this is the one that we'll use to configure the security of the web paths in our application for the logging in, logout, and et cetera.
//		// override method to configure users for in-memory authentication ... 
//		@Override
//		protected void configure(HttpSecurity http) throw Exception {
//			// So, this configure method has an HTTP Security so we'll use this to configure Spring Security. The first line, here, of .authorizeRequests, meaning strict access based on the servlet request coming in, 
//			http.authorizeRequests()
//				// then we'll say .anyRequests .authenticated means that for any request coming to the app it must be authenticated. The user must be logged in. 
//				.anyRequest().authenticated()
//				.and()
//				// And for our formLogin, we'll customize the login process where for the actual login page we'll show our custom form for this given request mapping of /showMyLoginPage. 
//				.formLogin()
//					.loginPage("/showMyLoginPage")
//					// And then the login form will submit the data or post the data to this URL for processing So we'll have /authenticateTheUser, This's where spring security will go through and check the user ID and the password. 
//					// Now these 2 entries here, you can actually give any values for this configuration, simply have to stay consistent in your application. 
//					.loginProcessingUrl("/authenticateTheUser")
//					// Allow everyone to see login page. no need to login, cause they have to see something first
//					.permitAll();
//		}
//	}
//```	
//1. configure(AuthenticationManagerBuilder) -> Configure users(in memory, database, idap, etc)
//2. configure(HttpSecurity) -> Configure security of web paths in application, login, logout etc
//
//* That's the one when we overrode that method to setup our in memory authentication using that authentication manager builder. And we'll also override a second method called configure that takes a parameter for HTTP security. And this's the one that we'll use to configure the security of the web paths in our application, the login form, the logout process, and so on.
//
//-> "TODO:  We need to create a controller for this request mapping"
//
//* Now as far as the things that we need to do, we actually need to create a controller for this request mapping. So we need to create some code, and then we need to handle for the get mapping for /showMyLoginPage. 
//
//-> "No Controller Request Mapping required for this. We get this for free:-)"
//
//* There's no controller request mapping required for the processing URL. You get this for free, this is some of the Spring magic that'll handle everything for you behing the scenes as for as checking the user ID and password. 
//
//
//#### Step 2: Develop a Controller to show the custom login form
//
//-> LoginController.java
//```java
//	@Controller
//	public class LoginController {
//
//		@GetMapping("/showMyLoginPage")
//		public String showMyLoginPage() {
//			return "plain-login";
//		}
//	}
//
//```
//"/WEB-INF/view/plain-login.jsp"
//
//#### Step 3: Create custom login from
//
//* Send data to login processing URL: /authenticateTheUser
//	* this's based on the configuration information we setup in that Spring Security config file. 
//	* You can give ANY values for the configuration. like I said earlier, simply stay consistent in your application. 
//* Login processing URL will be handled by Spring Security Filters 
//* You get it for free ... no coding required
//* Must POST the data
//```xml
//	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
//		...
//	</form:form>
//```
//* Best practice is to use the Spring MVC Form tag <form:form>
//	* Provides automatic support for security defencses (more on this )
//* Spring Security defines default names for login form fields
//	* User name field: username
//	* Password field: password 
//
//```xml
//	User name: <input type="text" name="username" />
//	Password: <input type="password" name="password" />
//```
//
//* So Spring Security's gonna read the form data and use that to authentication the user. So Spring will do all the authentication and check in the background as long as you provide the form field names that Spring is expecting. 
//
//
//-> WEB-INF/view/plain-login.jsp
//```xml
//	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
//	// Reference Spring MVC form tags
//	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
//		...
//		// So i'll have action equals authenticate the user, and again remember when the form submits the data, it's making use of that login processing URL, and then we just go ahead and  drop in the fields here for username and also password,
//
//		<p>User name: <input type="text" name="username" /></p>
//		<p>Password: <input type="password" name="password" /></p>
//		<input type="submit" value="Login" />
//		// So remember that authenticate user, that'll actually be processed by the Spring Security Filters in the background and validate the actual username and password. 
//	</form:form>
//
//```
//
//##### More Info on Context Path
//
//```xml
//	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
//		...
//	</form:form>
//```
//* Context root and context path basically a same thing So you'll hear names passed around different ways, some people will say context path, others will say  context root, but they're basically the same thing, Gives us access to context path dynamically so we can included on the fly for any links that we may have in our application for like form submissions, href links and so on, 
//
//##### Why use Context Path?
//
//* Allow us to dynamically reference context path of application 
//* Helps to keep links relative to application context path 
//* If you change context path of app, then links still work
//* Much better than hard-coding context path...
//
//
//* there's a problem here and we can actually break this Let's open up a new private window, just so we have a brand new session, and I wanna, test this login thing here, So i'm gonna enter a bad username and a bad password, it didn't log in, but notice there's no error message. What's up with that 
//* Now, earlier in the class, when we used that default login page provided by Spring, Spring gave us a lot of functionality in that page, So they would even tell you if the user failed to login. 
//* For our custom login page we need logic to handle for login error messages "We need to logic handle for that we need to modify a form to display an error message if the login fails."
//
//
//##### Failed Login
//
//* When login fails, by default Spring Security will...
//* Send user back to your login page
//* Append an error parameter: ?error
//
//* Check on Tab, is the user authenticated no, that's a failed login. So Spring will actually send a user back to the login form and they'll actually append a parameter to the URL, error, 
//* And we can actually write code to check for that. Now rememeber, this will be on the URL so this's how it maps up here with the URL that's in the browser and then the actual parameter here And we can check for that parameter and then write code accordingly 
//
//###### Development Process
//
//1. Modify custom login form
//	1. Check the error parameter
//	2. If error parameter exists, show an error message (JSTL can help with this :-)
//
//
//###### 1: Modify custom login form
//
//```xml
//<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
//...
//<form:form action="..." method="...">
//	// Now remember that error parameter's actually passed over by spring security automatically in the case of a failed login so we're simply writing code to handle for that.
//	<c:if test="${param.error != null}">
//		<i>Sorry! You entered invalid username/password.</i>
//	</c:if>
//</form:form>
//
//```



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("MANAGER"))
			.withUser(users.username("susan").password("test123").roles("ADMIN"));
	}
	// Now gonna override the methods HTTP security,

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll();
	}
	
}
