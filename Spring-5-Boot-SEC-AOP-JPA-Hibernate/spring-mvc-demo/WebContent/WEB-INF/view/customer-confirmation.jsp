<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jstl tags looping over the collections -->
<!DOCTYPE html>
<html>
	<head>
		<title>
			Student Confirmation
		</title>
	</head>
	<body>
		The student is confirmed: ${customer.firstName} ${customer.lastName}
		<br><br>
		Free passes: ${customer.freePasses}
		<br> <br>
		Postal Code: ${customer.postalCode}
		<br> <br>
		Course Code: ${customer.courseCode}
		<br> <br>
	</body>
</html>
