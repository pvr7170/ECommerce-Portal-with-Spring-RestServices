$(document).ready(function () {
    $("#doLogin").click(function () {
        var username = $("#username").val();
        var pass = $("#pass").val();

        $.get("http://localhost:8080/AllUsers", function (data) {
            $.each(data, function (i, contact) {
                if (contact.loginId == username && contact.password == pass) {
                    window.location = "/WelcomeUser";
                } else {
                    msg = "Invalid username or password!";
                }
                $("#message").html(msg);
                
            });

        });
    });
});