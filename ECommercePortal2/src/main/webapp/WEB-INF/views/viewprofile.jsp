<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
 #firstname ,#lastname, #password, #address{
     background-color: #4CAF50;
    border: none;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    margin: 4px 2px;
    }
#quan{
color:white;
font-size: 20px;
font-weight:bold;
font-style: italic;
}
 #updateuser{
     background-color: red;
    border: none;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
}
p#username{
display: none;
}
h2{
font-size:15px;
}
h3{
color:green;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="/js/UpdateUser.js"></script>
<title>Your Profile</title>
</head>
<body>
<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>
<h3 align="right"><a href="/WelcomeUser?name=<%=request.getParameter("id")%>"> (- Back to Products List </a></h3>
	<h2 align="center">Your Profile details</h2>
	
	<p id="username"><input type="button" id="user" value="<%=request.getParameter("id")%>"></p>
	
	 <div id="menu" align="center">
	 
	 <h3 align="center">Enter New Details:</h3>
         
         <p id="quan">First Name:  <input type="text" id="firstname" value="${ViewUser.firstName}" placeholder="Enter New FirstName"></p>
         <p id="quan">Last Name:  <input type="text" id="lastname" value="${ViewUser.lastName}" placeholder="Enter New LastName"></p>
         <p id="quan">Password:  <input type="text" id="password" value="${ViewUser.password}" placeholder="Enter New Password"></p>
         <p id="quan">Address:  <input type="text" id="address" value="${ViewUser.address}" size="70" placeholder="Enter New Address including Zip Code"></p>
         
         <p><input type="button" value="Edit" name="updateuser" id="updateuser"></p>
     </div>
	

</body>
</html>