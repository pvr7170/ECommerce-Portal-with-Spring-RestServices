$(document).ready(function () {
    $("#doRegister").click(function () {

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        var loginId = $("#loginId").val();
        var password = $("#password").val();
        var confirmpassword = $("#confirmpassword").val();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var address = $("#address").val();

        var json = { "loginId": loginId, "password": password, "firstName": firstName, "lastName": lastName, "address": address };
       
        if (loginId == '' || password == '' || confirmpassword == '' || firstName == '' || lastName == '' || address == '') {
            alert("Please fill out all fields...!!!");
        } else if ((password.length) < 6) {
            alert("Password should atleast 6 character in length...!!!");
        } else if (!(password).match(confirmpassword)) {
            alert("Your password don't match Confirm password. Try again?");
        } else {
           
            $.ajax({
                url: $("#adduser").attr("action"),
                type: "POST",
                data: JSON.stringify(json),
               // contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (data) {
                    if (data == "You have Successfully Registered.....") {
                        $("form")[0].reset();
                    }
                    alert("You have Successfully Registered.....Please Login to Continue shopping");
                    window.location = "/Login";
                }
                });
        }
        
             });
           
    });