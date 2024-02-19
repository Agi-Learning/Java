package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//# Spring Security - Adding Logout Support
//
//## Development Process
//
//1. Add logout support to Spring Security Configuration
//2. Add logout button to JSP page 
//3. Update login form to display "logged out" message
//
//### Step 1: Add logout support to Spring Security Configuration
//
//```java
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.anyRequest().authenticated()
//			.and()
//			.formLogin()
//				.loginPage("/showMyLoginPage")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//			.and()
//			.logout().permitAll();
//	}
//
//```
//* So this basically gives us logout support that will expose the default URL for logging out, /logout. 
//
//### Step 2. Add logout button to JSP page 
//
//* Send data to default logout URL: /logout
//```xml
//	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
//		<input type="submit" value="Logout" />
//	</form:form>
//	<!-- Effectly you need to post data across for logout, and you need to make use of a form. And the get method is disabled dy Default. -->
//
//```
//* Logout URL will be handled by Spring Security Filters
//* You get it for free ... no coding required
//
//#### Logout process
//
//* When a logout is processed, by default Spring Security will....
//* Invalidate user's HTTP session and remove session cookies, etc
//* Send user back to your login page
//* Append a logout parameter: ?logout
//
//### 3. Update login form to display "logged out" message
//
//1. Update login form
//	1. Check the logout parameter
//	2. If logout parameter exists, show "logged out" message
//
//#### Modify Login form - check for "logout"
//
//-> WEB-INF/view/plain-login.jsp
//```xml
//	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
//	...
//
//	<c:if test="${param.logout != null}">
//		<i>You have been logged out.</i>
//	</c:if>
//	
//	...
//```

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
public class DemoAppConfig {
	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
}