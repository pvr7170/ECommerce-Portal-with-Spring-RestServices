$(document).ready(function () {
    $("#updateuser").click(function () {
    	
    	 var token = $("meta[name='_csrf']").attr("content");
         var header = $("meta[name='_csrf_header']").attr("content");
         
         var username = $("#user").val();
    	
         var firstName = $("#firstname").val();
    		var lastName = $("#lastname").val();
    		var password = $("#password").val();
    		var address = $("#address").val();
    		
        
    var json = { "password": password, "firstName": firstName, "lastName": lastName, "address": address };
       
        if(password == '') {
            alert("Please Enter Password...!!!");
        }else if ((password.length) < 6) {
            alert("Password should be atleast 6 characters in length...!!!");
        } 
        else {
             $.ajax({
                url: "http://localhost:8080/AllUsers/"+username,
                type: "PUT",
                contentType: "application/json",
                data: JSON.stringify(json),
                success:function(response) {
                	alert("New Details updated Successfully");
                	 window.location = "/viewprofile/"+username+"?id="+username;
                },
                error:function(response){
                	alert("Error updating Details");
                	window.location = "/viewprofile/"+username+"?id="+username;

                }
             });
             
           }
        
       });
 });