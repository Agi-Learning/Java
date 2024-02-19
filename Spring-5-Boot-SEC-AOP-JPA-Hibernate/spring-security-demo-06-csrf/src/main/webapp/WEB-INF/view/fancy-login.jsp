<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
# Cross Site Request Forgery (CSRF)

## Spring Security

* Spring Security protects against Cross-Site Request Forgery (CSRF)

### What is CSRF?

* A security attack where an evil website tricks you into executing an action on a web application that you are currently logged in. 

### CSRF Examples

* You are logged into your backing app
	* tricked into sending money to another person
* You are logged into an e-commerce app
	* tricked into purchasing unwanted items

### CSRF Protection

* To protect against CSRF attacks
* Embed additional authentication data/token into all HTML forms
* On subsequent requests, web app will verify token before pro


 * Now in terms of Spring Security support for CSRF, that's part of the Spring Security Filters, so these filters can actually generate tokens to send back to the browser. You can use this in your HTML forms. And you can send the data over accordingly. And again, the Spring Security Filters will verify the tokens to make sure they're valid for this given user session before actually processing the request. 

### Spring Security's CSRF Protection

* CSRF protection is enabled by default in Spring Security
* Spring Security uses the Synchronizer Token Pattern
	* Each request includes a session cookie and randomly generated token
* For request processing, Spring Security verifies token before processing 
All of this is handled by Spring Security Filters

### When to use CSRF Protection?

* The Spring Security team recommends
* Use CSRF protection for any normal browser we requests
* If you are building a service for non-browser clients 
	* You may want to disable CSRF protection (after careful review)


### Use Spring Security CSRF Protection

* For form submissions use POST instead of GET
* Include CSRF token in form submission
* <form:form> automagically adds CSRF token
* If you don't use <form:form>, you must manually add CSRF token


### Manually add CSRF token

```xml
	<form action="..." method="POST">
		<input type="hidden"
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
```

### What happens if you don't include CSRF token?

* Status 403 Forbidden. (chunckles)

### CSRF Resources

* CSRF Security Reference
	* https://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF)

* Spring Security CSRF Support
	https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#csrf

-->

<html lang="en">

<head>
	
	<title>Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Login Form -->
					<form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="form-horizontal">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
									<!-- Check for login error -->
									<c:if test="${param.error != null}">		            
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											Invalid username and password.
										</div>
									</c:if>
									
									<c:if test="${param.logout != null}">
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											You have been logged out.
										</div>
									</c:if>            
									
								   	

					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<input type="text" name="username" placeholder="username" class="form-control">
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<input type="password" name="password" placeholder="password" class="form-control" >
						</div>

						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Login</button>
							</div>
						</div>
						<!-- I'm manually adding tokens ... Bro! -->
						<input type="hidden"
								name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						
					</form>

				</div>

			</div>

		</div>

	</div>

</body>
</html>