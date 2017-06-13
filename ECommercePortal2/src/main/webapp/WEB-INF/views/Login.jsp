<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
  <style>
  #doLogin{
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
  
  #pass1{
  margin-left:680px;
  }
  
table {
    border-collapse: collapse;
}

td {
    padding-top: .5em;
    padding-bottom: .5em;
}
  </style>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    <script type="text/javascript">
window.history.forward();
function noBack(){
	window.history.forward();
        }
    </script>

    <!--To check user credential by Rest Link-->
    <script src="js/Login.js"></script>
    
    
    <title>ECommerce Portal</title>
</head>
<body onLoad="noBack();">
    <h1 align="center">Welcome ECommerce Online shopping portal</h1>
    <h2 align="center">User's Login Page:</h2>
    <h2 id="message" style="color:red"></h2>
    <div align="center">
        <table>
            <tr>
                <td>User Name: </td>
                <td><input type="text" id="username" name="username" placeholder="Enter username here" size="30" required="required" /></td>
            </tr>
            
            <tr>
                <td>Password: </td>
                <td><input type="password" id="pass" name="pass" placeholder="Enter password here" size="30" required="required" /></td>
            </tr>

            <tr>
                <td><input type="button" value="Login" name="doLogin" id="doLogin" onclick="userID()"/></td>
            </tr>
        </table>
    </div>
    <p id="pass1"><a href="/forgotpassword" style="color:red">Forgot password?</a></p>
        <h3><font color="green">New user? <a href="/Register">Click here to Register</a></font></h3>
        
   
</body>
</html>