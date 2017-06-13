$(document).ready(function () {
	
    $("#updatequan").click(function () {

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        var username = $("#user").val();
        
        var cartLine_Id = $("#cartid").val();
        var cartLine_Quantity = $("#quantity").val();
       
        var product_Id = $("#proid").val();
        var product_Name = $("#prodname").val();
        var product_Supplier = $("#prodsup").val();
        var product_Price = $("#prodprice").val();
        
        var json = {"productModel": {"product_Id": product_Id, "product_Name": product_Name, "product_Supplier": product_Supplier, "product_Price": product_Price }, "cartLine_Id": cartLine_Id, "cartLine_Quantity": cartLine_Quantity };
       
        	$.ajax({
                url:"http://localhost:8080/UpdateCartItem/"+cartLine_Id, 
                type: "PUT",
                contentType: "application/json",
                data: JSON.stringify(json),
                success:function(response) {
                	alert("Quantity Updated Successfully");
                	 window.location = "/viewCart/"+username+"?id="+username;
                },
                error:function(response){
                	alert("Quantity Updation Failed...Please Try again");
                	window.location = "/viewCart/?id="+username;

                }
             });
        });
    
    
    $("#delete").click(function () {

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        var username = $("#user").val();
        
        var cartLine_Id = $("#cartid").val();
        var cartLine_Quantity = $("#quantity").val();
       
        var product_Id = $("#proid").val();
        var product_Name = $("#prodname").val();
        var product_Supplier = $("#prodsup").val();
        var product_Price = $("#prodprice").val();
        
        $.ajax({
                url:"http://localhost:8080/removeCartItem/"+username+"/"+cartLine_Id, 
                type: "DELETE",
                contentType: "application/json",
                success:function(response) {
                	alert("Cart's Product Deleted Successfully");
                	 window.location = "/viewCart/"+username+"?id="+username;
                },
                error:function(response){
                	alert("Deleting Failed...Please try again");
                	window.location = "/viewCart/?id="+username;

                }
             });
        });
    
    
           
    });