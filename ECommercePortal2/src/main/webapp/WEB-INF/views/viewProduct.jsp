<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
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
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script type="text/javascript">
function newDoc(){
	window.location.assign("/shoppingCart");
}


</script> 
    
<title>Product details</title>
</head>
<body>

		<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>

	
  <div id="menu" align="center">
           
               <img src="${paginationProduct.product_Image}" width="300" height="300">
               <h3>Name: ${paginationProduct.product_Name}</h3>
               <h3>Supplier: ${paginationProduct.product_Supplier}</h3>
               <h3>Price: <fmt:formatNumber value="${paginationProduct.product_Price}" type="currency"/></h3>
               <h3><input type="button" value="Add to Cart" id="addcart" onclick="newDoc()"/></h3>
   
       </div>
 
	
</body>
</html>