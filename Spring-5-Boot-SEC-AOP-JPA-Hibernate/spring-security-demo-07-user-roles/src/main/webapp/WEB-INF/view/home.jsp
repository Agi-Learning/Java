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
	
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>