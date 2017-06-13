<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
</head>
<style>
img {
    display: block;
    margin: 0 auto;
   
}
</style>
<body>
	<div class="container">
		
			<h1 align="center">${message}</h1>	
	
			<img src="/images/shop1.jpg" width="700" height="400">
			
			<h3>User's Login Page: <a href="/Login">Click here</a></h3>
			
			<h3 align="right">Admin's Login Page: <a href="/Admin">Click here</a></h3><br>
			
			
		</div>

	
</body>
</html>