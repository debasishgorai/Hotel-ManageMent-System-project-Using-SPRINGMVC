<%@page import="com.jsp.hotel_mangement_system.entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Products</title>
</head>
<body>
	<%
	List<Product> pr = (List<Product>) request.getAttribute("fetchallobj");
	%>
	<table border="1" cellpadding="5px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Discount</th>
			<th>Cost</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for (Product p : pr) {
		%>
		<tr>

			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getType()%></td>
			<td><%=p.getDiscount()%></td>
			<td><%=p.getCost()%></td>
			<td><a href="updateproduct?id=<%=p.getId()%>">Update</a></td>
			<td><a href="delete?id=<%=p.getId()%>">Delete</a></td>

		</tr>
		<%
		}
		%>
	</table>
	<a href="HotelHomePage.jsp">Back to main menu</a>
	<br>
	<a href="hotellogout">Logout</a>

</body>
</html>