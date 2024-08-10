<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Form</title>
</head>
<body>
	<form:form action="savehotel" modelAttribute="hotelobj">
		Enter Hotel Name: <form:input path="name"/><br>
		Enter Contact Num: <form:input path="mobileNumber"/><br>
		Enter  Email: <form:input path="email"/><br>
		Enter Password: <form:input path="password"/><br>
		Enter Address: <form:input path="address"/><br>
		<input type="submit">
	</form:form>

</body>
</html>