<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="_csrf" th:content="${_csrf.token}" />
    <meta name="_csrf_header" th:content="${_csrf.headerName}" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
    <style>
    #doRegister{
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
    
    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
   

    <!--To Register new user by Rest Link-->
    <script type="text/javascript" src="js/Register.js"></script>

    <title>ECommerce Registration Page</title>
</head>
<body>



    <h1>ECommerce Online shopping portal</h1><br>
    <h2>User's Registration page</h2><br />
    <h3>Enter below details to Register:</h3>
    <p>(*)All Fields mandatory</p>

    <div align="center">
        <form class="form" id="adduser" action="http://localhost:8080/AddUsers">
            <table>
                <tr>
                    <td>Login ID/Username:*  </td>
                    <td><input type="text" name="loginId" id="loginId" placeholder="Your New LoginID here" size="30" required="required" /></td>
                </tr>
                <tr>
                    <td>Password:*  </td>
                    <td><input type="password" name="password" id="password" placeholder="Enter password here" size="30" required="required" /></td>
                </tr>
                <tr>
                    <td>Confirm Password:*  </td>
                    <td><input type="password" name="confirmpassword" id="confirmpassword" placeholder="Confirm password here" size="30" required="required" /></td>
                </tr>
                <tr>
                    <td>FirstName:*  </td>
                    <td><input type="text" name="firstName" id="firstName" placeholder="Your FirstName here" size="30" required="required" /></td>
                </tr>
                <tr>
                    <td>LastName:*  </td>
                    <td><input type="text" name="lastName" id="lastName" placeholder="Your LastName here" size="30" required="required" /></td>
                </tr>
                <tr>
                    <td>Address:*  </td>
                    <td><input type="text" name="address" id="address" placeholder="Enter Complete Address including Zip code" size="100" required="required" /></td>
                </tr>
                <tr>
                    <td><input type="button" value="Register" name="doRegister" id="doRegister" /></td>
                </tr>
            </table>
            <h3> <font color="red">If Registered previously, Please click <a href="Login.html">HERE</a> to Login</font></h3>
</form>
</div>
</body>
</html>