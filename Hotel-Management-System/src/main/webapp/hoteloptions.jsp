<%@page import="com.jsp.hotel_mangement_system.entities.Hotel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Integer hotel = (Integer) session.getAttribute("hotelinfo");
	if (hotel != null) {
	%>
	<h1>${message}</h1>
	<a href="addproduct">Add Product</a>
	<br>
	<a href="viewallproduct">View All Products</a>
	<br>
	<a href="updateproduct">Update Product By Id</a>
	<br>
	<a href="deleteproduct">Delete Product By Id</a>
	<%
	} else {
	%>
	<a href="HotelLogin.jsp">Login First</a>

	<%
	}
	%>

</body>
</html>