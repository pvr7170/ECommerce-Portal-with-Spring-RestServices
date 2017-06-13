<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="_csrf" th:content="${_csrf.token}" />
    <meta name="_csrf_header" th:content="${_csrf.headerName}" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
 <style>
#prodid p, #prodname p, #prodsup p, #prodprice p{
	background-color: white;
    border: none;
    color: black;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 6px;
    margin: 2px 1px;
 }
#quan{
color:Aqua;
font-size: 20px;
font-weight:bold;
font-style: italic;
}
p#username{
display: none;
}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script src="/js/AddCart.js"></script>
<title>Product details</title>
</head>
<body>
<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>
<h3 align="right"><a href="/WelcomeUser?name=<%=request.getParameter("ids")%>"> (- Back to Products List </a></h3>
	
<p align="left">(*)Mandatory Fields</p>
	
  <div id="menu" align="center">
  
  	<p id="username"><input type="button" id="user" value="<%=request.getParameter("ids")%>"></p>
  
  		<p><img src="/images/${paginationProduct.product_Id}.jpg" width="350" height="350"></p>
          
         
              <p id="username">Displaying Products:  <input type="button" id="prodid" value="${paginationProduct.product_Id}" disabled></p>
              <p>Name:  <input type="button" id="prodname" value="${paginationProduct.product_Name}" disabled></p>
          	  <p><img src="/images/arrow.png" width="70" height="30">Supplier:  <input type="button" id="prodsup" value="${paginationProduct.product_Supplier}" disabled></p>
          	  <p>Price:  $<input type="button" id="prodprice" value="${paginationProduct.product_Price}" disabled></p>
          	  
         <%-- <form class="form" id="addcart" action="http://localhost:8080/AddCartItems/<%=request.getParameter("ids")%>"> 
         	  <p id="quan">*Enter Quantity (Max:4 pieces):  <input type="text" style="text-align:center;" id="quantity" placeholder="Enter quantity" required="required"></p>
         	  <p><input type="button" value="Add to Cart" name="addcart" id="addcart"></p>
         </form> --%>
      <p id="quan">*Enter Quantity (Max:4 pieces):  <input type="text" style="text-align:center;" id="quantity" placeholder="Enter quantity" required="required"></p>
       	  <p><input type="button" value="Add to Cart" name="addcart" id="addcart"></p>
       </div>
 
	
</body>
</html>