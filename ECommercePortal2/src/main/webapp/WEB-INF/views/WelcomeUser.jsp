<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    <script type="text/javascript">
window.history.forward();
function noBack(){
	window.history.forward();
        }
    </script>
    
  <script type="text/javascript">
  $(document).ready(function () {
	  var p1=$("#p1").val();
	  var p2=$("#p2").val();
	  console.log(p1);
	  $.get("http://localhost:8080/AllProducts", function (data) {
          $.each(data, function (i, contact) {
        	  	if(contact.product_Id == p1){
        	  		var sam = contact.product_Price;
        	 }
        	  	$("#message").html(sam);
          });
		  });
  });
  
  
  </script>
  
   <title>User's Shopping Page</title>
</head>
<body onLoad="noBack();">


	<p id="log" align="right" style="font-size:25px;"><a href="/Logout">Logout</a></p>

	
    <h1>Welcome user</h1>

    <h2>Choose or explore products and continue shopping</h2>
    <br><br>
    
    <div id="ProductsList">
    
    <h3>Electronics</h3>
   	
   	 
    <a href="/ViewProdDetails">
   <img src="images/SamsungS6Edge.jpg" alt="samsungs6" width="200" height="200">
	</a>
	<ul>
	<li id="p1" value="1">Samsung s6 Edge - 32GB</li>
    </ul>
    <div>Price: $<p id="message"></p></div>
  </div>
   

</body>
</html>