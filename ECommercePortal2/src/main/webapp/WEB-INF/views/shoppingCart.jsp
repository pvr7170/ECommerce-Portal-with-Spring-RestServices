<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    
 <script type="text/javascript">
 
  </script>

<title>Shopping Cart</title>
</head>
<body>
				<div>
				<ul>
				<li id="prodID"></li>
				<li id="prodImage"><img src="' + item.ImageURL + '"  name="productimage" /></li>
				<li id="prodName"></li>
				<li id="prodPrice"></li>
				<li id="prodSup"></li>
				</ul>
				
				
				</div>
			

               <h3><a href="/ViewProducts" align="right"> (- Back to shopping </a></h3>
		
		
</body>
</html>