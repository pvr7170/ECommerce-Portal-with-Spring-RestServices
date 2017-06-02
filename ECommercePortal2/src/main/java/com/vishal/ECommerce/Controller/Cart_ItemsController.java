package com.vishal.ECommerce.Controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

import com.vishal.ECommerce.Model.Cart_Items;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Service.Cart_ItemsService;
import com.vishal.ECommerce.Service.UserService;
import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class Cart_ItemsController {

	@Autowired
	private Cart_ItemsService cartservice;
	
	
	//---------- Get All cart items-----------------------------------
		@RequestMapping(value="/AllCartItems", method=RequestMethod.GET)
		public ResponseEntity<List<Cart_Items>> getAllItems() {
			List<Cart_Items> list =	cartservice.getAllitmes();
			return new ResponseEntity<List<Cart_Items>>(list, HttpStatus.OK);
	   }
	
	//---------- Get cart items by ID-----------------------------------
	@RequestMapping(value="/AllCartItems/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cart_Items> getCartById(@PathVariable("id") int id) {
		Cart_Items cartitems = cartservice.getItemById(id);
		return new ResponseEntity<Cart_Items>(cartitems, HttpStatus.OK);
	}
	
	//-----------Add cart Items by User's LoginId and CartItems model-----------------------
	@RequestMapping(value="/AddCartItems/{id}", method=RequestMethod.POST)
	public ResponseEntity<String> AddCartItemByLoginId(@PathVariable("id") String Login_Id, @RequestBody Cart_Items cartitems){
		try {
			cartservice.AddItemToCart(Login_Id, cartitems);
			
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("Error Adding Cart by LoginId");
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
	}
	
	//---------- update User my style-----------------------------------
		@RequestMapping(value="/UpdateCartItem/{CartLine_Id}", method=RequestMethod.PUT)
		public ResponseEntity<String> updateCart(@RequestBody Cart_Items cartitems, @PathVariable("CartLine_Id") int CartLine_Id){
			try {
				cartservice.updateCart(cartitems, CartLine_Id);
				
				return new ResponseEntity<String>("Success",HttpStatus.OK);
			}catch (Exception e) {
				System.out.println("Error updating Cart by LoginId");
				e.printStackTrace();
			}
			return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
		//-------------Remove Cart Item--------------------------------------------
			@RequestMapping(value="/removeCartItem/{Login_Id}/{CartLine_Id}", method=RequestMethod.DELETE)
			public ResponseEntity<String> removeCart(@PathVariable("Login_Id") String Login_Id,@PathVariable("CartLine_Id") int CartLine_Id){
				try {
					
					//destroy relationship between user and cart 
					cartservice.removeItemfromCart(Login_Id, CartLine_Id);
					
					//destroy relationship between cart and product
					
					//delete item from cart
					cartservice.deleteitemfromcarttable(CartLine_Id);
					
					return new ResponseEntity<String>("Success",HttpStatus.OK);
				}catch (Exception e) {
					System.out.println("Error removing from Cart by LoginId,Cart_Id");
					e.printStackTrace();
				}
				return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
			}
				
}

