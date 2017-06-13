<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

h2#tell {
    margin-top: 20px; text-align:center; font-size:25px;
}

h2#support {
    margin-top: 20px; text-align:center; font-size:25px;
}
h2#query {
    margin-top: 50px;
    text-align: left;
    font-size: 25px;
}
ul#concern {
    margin-top: 60px;
    font-size: 17px;
    margin-left: 15px;
    width: 200px;
    
}
ul li#concern1 {
    display: block;
    color: white;
    padding: 8px 16px;
    text-decoration: none;
    
}

 ul li#concern1:hover {
        background-color: green;
        color: white;
 }
 p#username{
display: none;
}

</style>
<meta name="_csrf" th:content="${_csrf.token}" />
    <meta name="_csrf_header" th:content="${_csrf.headerName}" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    
<title>E-Commerce Help</title>
</head>
<body>
<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>
<h3 align="right"><a href="/WelcomeUser?name=<%=request.getParameter("id")%>"> (- Back to Products List </a></h3>

	<p id="username"><input type="button" id="user" value="<%=request.getParameter("id")%>"></p>
	<h2 align="center">ECommerce Online shopping portal</h2><br>
<div id="main">
	<h2 id="tell">Tell us what's your Concern?</h2>
			<h2 id="support">The Support Team is Available 24/7 to assist our customers with Concerns</h2>	

			
			<h2 id="query">Please select Query below:</h2>

			<ul id="concern">
				<li id="concern1"><a href="#">&#8594; Your Orders  </a></li>
				<li id="concern1"><a href="#">&#8594; Account Settings  </a></li>
				<li id="concern1"><a href="#">&#8594; Payment Options  </a></li>
				<li id="concern1"><a href="#">&#8594; Returns and Refunds  </a></li>
			</ul>
	


</div>

</body>
</html>