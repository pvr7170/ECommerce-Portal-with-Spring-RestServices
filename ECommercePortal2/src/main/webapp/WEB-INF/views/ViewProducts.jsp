<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    
   <title>Product List page</title>
</head>
<body>
<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>
	
       <div id="menu">
       <h3 align="right"><a href="/WelcomeUser?name=<%=request.getParameter("id")%>"> (- Back to Products List </a></h3>
       
     <h2>Your List of products <%=request.getParameter("id")%></h2>
     
       <c:forEach items="${paginationProducts}" var="prodInfo">
         
           <ul>
               <li><img src="/images/${prodInfo.product_Id}.jpg" width="250" height="200"></li>
               <li>Name: ${prodInfo.product_Name}</li>
               <%-- <li>Supplier: ${prodInfo.product_Supplier}</li> --%>
               <li>Price: <fmt:formatNumber value="${prodInfo.product_Price}" type="currency"/></li>
               <li><a href="/viewProduct/${prodInfo.product_Id}/?ids=<%=request.getParameter("id")%>" id="addcart">View Product details / Add to Cart</a></li>
           <%--     <li><a href="/shoppingCart/${prodInfo.product_Id}/<%=request.getParameter("id")%>" id="addcart">Add to Cart</a></li> --%>
              <p>-----------------------------------------------------------------------------------------</p>
           </ul>

       </c:forEach>
	 
   </div>
		
	
		
		
</body>
</html>