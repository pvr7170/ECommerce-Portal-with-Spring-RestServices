<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#addcart {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 12px 27px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 2px 1px;
    cursor: pointer;
}



</style>
<script type="text/javascript">
function newDoc(){
	window.location.assign("/shoppingCart");
}


</script> 


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    
   <title>Product List page</title>
</head>
<body>
<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>
	<p id="log" align="right" style="font-size:25px;"><a href="/WelcomeUser">view more products</a></p>
	
		 <c:forEach items="${paginationProducts}" var="prodInfo">
       <div id="menu">
           <ul>
               <li><img src="${prodInfo.product_Image}" width="200" height="200"></li>
               <%--  <li id="proid">Serial Number: ${prodInfo.product_Id}</li> --%>
               <li>Name: ${prodInfo.product_Name}</li>
               <li>Supplier: ${prodInfo.product_Supplier}</li>
               <li>Price: <fmt:formatNumber value="${prodInfo.product_Price}" type="currency"/></li>
               <li><a href="/viewProduct/${prodInfo.product_Id}" id="addcart">View Product details</a></li>
               <li><input type="button" value="Add to Cart" id="addcart" onclick="newDoc()"/></li>
               <p>-----------------------------------------------------------------------------------------</p>
           </ul>
       </div>
 
   </c:forEach>
		
	
		
		
</body>
</html>