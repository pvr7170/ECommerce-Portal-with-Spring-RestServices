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

import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
/*	//---------- Get All users-----------------------------------
	@RequestMapping(value="/AllUsers", method=RequestMethod.GET)
	public ResponseEntity<List<UserModel>> getAllUsers() {
		List<UserModel> list = userservice.getAllUsers();
		return new ResponseEntity<List<UserModel>>(list, HttpStatus.OK);
   }*/
	@RequestMapping(value="/AllUsers", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllUsers() {
		List<UserModel> list = userservice.getAllUsers();
		return new ResponseEntity<Object>(list, HttpStatus.OK);
   }
	
	//---------- Get User by ID-----------------------------------
	@RequestMapping(value="/AllUsers/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserModel> getUserById(@PathVariable("id") String id) {
		UserModel usermodel = userservice.getUserById(id);
		return new ResponseEntity<UserModel>(usermodel, HttpStatus.OK);
	}
	
	//---------- Add User-----------------------------------
	@RequestMapping(value="/AddUsers", method=RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody UserModel usermodel, UriComponentsBuilder builder) {
        try{
		boolean flag = userservice.addUser(usermodel);
        if (flag == false) {
        	System.out.println("Failed to add user");
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        }catch(Exception e){System.out.println("Caught exception,Add user failed");return null;}
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/AllUsers/{id}").buildAndExpand(usermodel.getLoginId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	
	//---------- update User my style-----------------------------------
	@RequestMapping(value="/AllUsers/{LoginId}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@PathVariable String LoginId, @RequestBody UserModel usermodel){
		try {
			userservice.updateUser(LoginId, usermodel);
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("Error updating");
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
	}
	
	//---------- Delete user-----------------------------------
	@RequestMapping(value="/AllUsers/{id}", method=RequestMethod.DELETE)
	public void DeleteUser(@PathVariable("id") String id){
		userservice.DeleteUser(id);
  }
	
//----------------------------------------User - Order Operations---------------------------------------------------------------------------------------------

	//---------- Add Order by User's Login_Id-----------------------------------
	@RequestMapping(value="/AddOrder/{Login_Id}", method=RequestMethod.POST)
	public ResponseEntity<String> AddOrderByLoginId(@PathVariable String Login_Id, @RequestBody OrdersModel ordersmodel){
		try {
			userservice.AddOrderByLoginId(Login_Id, ordersmodel);
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("Error Adding order by LoginId");
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
	}
	
	/*//---------- Delete All Orders by User's Login_Id-----------------------------------
	@RequestMapping(value="/DeleteAllOrders/{Id}", method=RequestMethod.DELETE)
	public void DeleteAllOrdersByLoginId(@PathVariable("Id") String Login_Id,OrdersModel ordersmodel){
		userservice.DeleteAllOrdersByLoginId(Login_Id,ordersmodel);
  }*/
	
	/*//---------- Delete Order by Order_Id and User's Login_Id-----------------------------------
	@RequestMapping(value="/DeleteUserOrder/{Login_Id}/{Order_Id}", method=RequestMethod.DELETE)
	public void DeleteOrderByOrderIdLoginId(@PathVariable("Login_Id") String Login_Id,@PathVariable("Order_Id") int Order_Id){
		userservice.DeleteOrderByOrderIdLoginId(Login_Id, Order_Id);
  }*/
	
		
}
