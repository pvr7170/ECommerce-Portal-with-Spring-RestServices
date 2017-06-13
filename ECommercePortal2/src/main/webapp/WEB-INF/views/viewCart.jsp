<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
 #updatequan, #checkout{
     background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
    }
input[type="text"] {
    width: 150px;
}
#delete{
 background-color: red; 
    border: none;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
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
#sub{
color:green;
font-size: 20px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 <script src="/js/updateCart.js"></script>   
<title>Your Cart</title>
</head>
<body>
<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>
<h2 align="center">Shopping Cart</h2>

	
	<h3 align="right"><a href="/WelcomeUser?name=<%=request.getParameter("id")%>"> (- Back to Products List</a></h3>
	
	<p id="username"><input type="button" id="user" value="<%=request.getParameter("id")%>"></p>
	<h2>Your ShoppingCart: </h2>

	<input type="button" value="Proceed to CheckOut" name="checkout" id="checkout" style="float:right;">
	
<c:forEach items="${ViewUserCart}" var="cartInfo">


			<input type="hidden" id="cartid" value="${cartInfo.cartLine_Id}">
			
			
			<input type="hidden" id="proid" value="${cartInfo.productModel.product_Id}">
			<input type="hidden" id="prodname" value="${cartInfo.productModel.product_Name}">
			<input type="hidden" id="prodsup" value="${cartInfo.productModel.product_Supplier}">
			<input type="hidden" id="prodprice" value="${cartInfo.productModel.product_Price}">
			
			
         
           <ul>
               <li><img src="/images/${cartInfo.productModel.product_Id}.jpg" width="250" height="200"></li>
               <li>Name: ${cartInfo.productModel.product_Name}</li>
               <li>Product Price: <fmt:formatNumber value="${cartInfo.productModel.product_Price}" type="currency"/></li>
               <li>Supplier: ${cartInfo.productModel.product_Supplier}</li>
               <li id="quan">Update Quantity:  <input type="text" style="text-align:center;" value="${cartInfo.cartLine_Quantity}" id="quantity" size="40" placeholder="update New quantity" required="required"></li>
   				<li><input type="button" value="Update Quantity" name="updatequan" id="updatequan">
               <li id="sub">Subtotal:  $${cartInfo.cartLine_Price}</li>
               <li><input type="button" value="Delete Product" name="delete" id="delete">
             <p>-----------------------------------------------------------------------------------------</p>
           </ul>

       </c:forEach>


</body>
</html>