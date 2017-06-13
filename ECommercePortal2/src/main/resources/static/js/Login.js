$(document).ready(function () {
    $("#doLogin").click(function () {
    	
        var username = $("#username").val();
        var pass = $("#pass").val();
        var msg;
        $.get("http://localhost:8080/AllUsers", function (data) {
            $.each(data, function (i, contact) {
                if (contact.loginId == username && contact.password == pass) {
                	 window.location = "/WelcomeUser?name="+username;
                } else {
                    msg = "Invalid username or password!";
                }
                $("#message").html(msg);
                
            });

        });
    });
});