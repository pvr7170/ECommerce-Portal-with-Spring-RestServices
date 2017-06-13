<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#validate{
   background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 8px 24px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    margin: 4px 2px;
    cursor: pointer;
  }
p{
color:red;  
  }
table {
    border-collapse: collapse;
}
td {
    padding-top: .5em;
    padding-bottom: .5em;
}
</style>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <title>Forgot password Recovery page</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
<h1 align="center">Welcome ECommerce Online shopping portal</h1><br>
    <h2 align="center">Customer's Password Recovery page:</h2><br><br>

<div align="center">
        <table>
            <tr>
                <td>Enter User Name: </td>
                <td><input type="text" id="username" name="username" placeholder="Enter username here" size="30" required="required" /></td>
            </tr>
            
            <tr>
                <td>Enter Email: </td>
                <td><input type="email" id="email" name="email" placeholder="Enter Email here" size="30" required="required" /></td>
            </tr>

            <tr>
                <td><input type="button" value="Validate" name="validate" id="validate"/></td>
            </tr>
        </table>
    </div><br><br><br>
	<p align="center">A notification will be sent to your Email along with password</p><br>
	 <h3 align="center"> <font color="red">Go back to Login page<a href="Login.html">  HERE</a></font></h3>
</body>
</html>