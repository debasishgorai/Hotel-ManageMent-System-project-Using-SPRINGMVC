<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Login</title>
</head>
<body>
	<h1>${message}</h1>
	<form action="hotelloginvalidate" method="post">
		Enter Email : <input type="email" name="email"><br>
		Enter Password : <input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>

</body>
</html>