$(document).ready(function () {
    $("#addcart").click(function () {
    	
    	 var token = $("meta[name='_csrf']").attr("content");
         var header = $("meta[name='_csrf_header']").attr("content");
         
    		var username = $("#user").val();
    		var cartLine_Quantity = $("#quantity").val();
    		var product_Id = $("#prodid").val();
    		var product_Name = $("#prodname").val();
    		var product_Supplier = $("#prodsup").val();
    		var product_Price = $("#prodprice").val();
    		var msg;
        
        var json = {"productModel": {"product_Id": product_Id, "product_Name": product_Name, "product_Supplier": product_Supplier, "product_Price": product_Price }, "cartLine_Quantity": cartLine_Quantity };
       
        if (cartLine_Quantity == '') {
            alert("Please Enter the quantity...!!!");
        } 
        
        else {
             $.ajax({
                url: $("#addcart").attr("action"),
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(json),
                success:function(response) {
                	alert("Product Successfully Added to Cart...Please Continue shopping");
                	 window.location = "/WelcomeUser?name="+username;
                },
                error:function(response){
                	alert("Product Failed to Add...Please enter correct Quantity and Try Again");
                	window.location = "/ViewProducts/?id="+username;

                }
             });
             
           }
        
       });
 });