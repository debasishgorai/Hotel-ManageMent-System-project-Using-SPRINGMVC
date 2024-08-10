<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
</head>
<body>
	<form:form action="saveproduct" modelAttribute="productobj">
		Enter Name : <form:input path="name"/>
		<br>
		Enter Type : <form:input path="type"/>
		<br>
		Enter Cost : <form:input path="cost"/>
		<br>
		Enter Discount : <form:input path="discount"/>
		<br>
		<input type="submit">
	</form:form>

</body>
</html>