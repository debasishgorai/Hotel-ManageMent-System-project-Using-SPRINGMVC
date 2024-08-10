<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	${message}
	<form action="adminloginvalidate" method="post">
		Enter Email: <input type="email" name="email"><br>
		Enter Password: <input type="password" name="password"><br>
		<input type="submit">
	</form>

</body>
</html>