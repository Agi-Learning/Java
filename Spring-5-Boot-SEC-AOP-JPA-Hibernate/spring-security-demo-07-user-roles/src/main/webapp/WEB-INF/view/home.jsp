<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security"
			uri="http://www.springframework.org/security/tags" %>
			
<!-- 
# Spring Security - User Roles

## Displaying User ID and Roles - Overview

* We have home page here we will make use of JSP tags to display the User ID and also the Role. And this is very useful, so once a user logs onto our system, we know who they are and also, just a list of the roles that they're assigned to. 

### Spring Security

* Spring Security provides JSP custom tags for accessing user ID and Roles ( So that make it very easy for us to add the support to our JSP page. )

### Development Process

1. Update POM file for Spring Security JSP Tag Library
2. Add Spring Security JSP Tag Library to JSP page
3. Display User ID 
4. Display User Roles

#### Step 1: Update POM file for Spring Security JSP Tag Library

```xml
	<dependency>
		<groupId>org.springframework.security</groupId>
		<artifactId>spring-security-taglibs</artifactId>
		<version>${springsecurity.version}</version>
	</dependency>
```

#### Step 2. Add Spring Security JSP Tag Library to JSP page

```jsp
	<%@ taglib prefix="security"
			uri="http://www.springframework.org/security/tags" %>
```

#### Step 3. Display User ID 

```jsp
	User: <security:authentication property="principal.username" />
```

* Display the user ID for the person who is currently logged in.

#### Step 4. Display User Roles

* authorities is same as user roles
```jsp
	Role(s): <security:authentication property="principal.authorities" />
```




 -->			
			
			
			
<!DOCTYPE html>
<html>
<head>
<title>
luv2code Company Home Page
</title>
</head>
<body>
	<h2>luv2code Company Home Page</h2>
	
	<p>Welcome to the luv2code company home page!</p>
	
	<hr>
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<!-- 
	
## Display Content Based on Roles

* So we have our home page that we've been using so for but the big question is, why show these links? Since John is an employee, he really shouldn't be able to see this content or links for the leadership meeting or the IT systems meeting. Now I know that we already have those URLs locked down with our security configurations but we really shouldn't show them this on the page since he doesn't have the given role for manager or admin. 
* What i'd like to do is display content based on roles so right now I'm logged in as Mary. We know that she's an employee and a manger so since she's a manager, she can actually see the manager specific content. 

### Spring Security JSP Tags

* What we can do is make use of Spring Security JSP Tags to display content based on the user role. 

```jsp
	<security:authorize access="hasRole('MANAGER')">
	<%-- 
	* What we can do is make use of Spring Security JSP Tags to display content based on the user role. So here i have security:authorize and then I give the role acces="hasRole('Manager')" so basically everything inside of this tag, will only get displayed for user with teh manager role. 
	* "One other thing" -> Even if you have a user who's somewhat savvy with their web browser, the user may attempt to view document source. This content isn't hidden, it's simply not included. So the resulting HTML page will not even have this content so they can't even try and backdoor the system and view your source because they won't be able to see the generated content. 
	 --%>
		<p>
			<a href="${pageContext.request.contextPath}/leaders">
				Leadership Meeting
			</a>
		</p>
	</security:authorize>
```

### Display Content Based on Roles
	
	
	
	
	 -->
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to/leaders ... this is for the managers -->
		
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to / systems ... this is for the admins -->
		
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peeps)
		</p>
	</security:authorize>
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>