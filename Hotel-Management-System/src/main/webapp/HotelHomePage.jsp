<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Home Page</title>
<style>
  body {
    font-family: 'Arial', sans-serif;
    background-color: LightCoral;
    text-align: center;
    padding-top: 100px;
  }

  h1 {
    font-family: 'Helvetica Neue', sans-serif;
    font-size: 48px;
    color: #333;
    text-shadow: 2px 2px 4px #007bff;
  }

  .button {
    background-color: #007bff; /* Blue */
    color: white;
    padding: 15px 25px;
    margin: 10px;
    text-decoration: none;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    display: inline-block;
    transition: background-color 0.3s, box-shadow 0.3s;
  }

  .button:hover {
    background-color: #0056b3;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
  }
</style>
</head>
<body>
	<h1>Hotel Home Page</h1>
	<a href="addhotel" class="button">Register</a>
	<br>
	<a href="HotelLogin.jsp" class="button">Login</a>

</body>
</html>


