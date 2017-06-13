<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
 <style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}
li {
    float: left;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
li a:hover {
    background-color: green;
}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
window.history.forward();
function noBack(){
	window.history.forward();
        }
    </script>
   <script src="js/Login.js"></script>
   <script src="/js/AddCart.js"></script>
   
  <title>User's Shopping Page</title>
</head>
<body onLoad="noBack();">


	<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>

	
    <h2 align="center">Welcome <%=request.getParameter("name")%>, Good Morning</h2>
    
   <ul>
    <li><a href="/updateprofile">Update Profile</a></li>
    <li><a href="/viewCart">View Cart</a></li>
    <li><a href="/orders">Your Orders</a></li>
    <li><a href="/contact">Contact Support</a></li>
  </ul>
    
    <h2 id="message" style="color:green"></h2>

    <h2>Choose or explore products and continue shopping</h2>
    <br><br>
    
    <div id="ProductsList">
    
    <h2>Products Available: </a></h2>
    	
    
    <h2><a href="/ViewProducts/?id=<%=request.getParameter("name")%>">List of Electronics</a></h2>	
    
   	<!-- <a href="/ViewProdDetails">
   <img src="images/SamsungS6Edge.jpg" alt="samsungs6" width="200" height="200">
	</a>
	<ul>
	<li id="p1" value="1">Samsung s6 Edge - 32GB</li>
    </ul>
    <div>Price: $<p id="message"></p></div> -->
  </div>
   

</body>
</html>