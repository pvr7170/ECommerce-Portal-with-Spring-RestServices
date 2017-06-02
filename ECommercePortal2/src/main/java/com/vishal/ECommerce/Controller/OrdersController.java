package com.vishal.ECommerce.Controller;

import java.util.List;
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
import com.vishal.ECommerce.Service.OrdersService;
import com.vishal.ECommerce.Service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class OrdersController {
		
	@Autowired
	private OrdersService ordersservice;
	
	//---------- Get All orders-----------------------------------
	@RequestMapping(value="/AllOrders", method=RequestMethod.GET)
	public ResponseEntity<List<OrdersModel>> getAllUsers() {
		List<OrdersModel> list = ordersservice.getAllUsers();
		return new ResponseEntity<List<OrdersModel>>(list, HttpStatus.OK);
		      }

	//---------- Get Order by ID-----------------------------------
		@RequestMapping(value="/AllOrders/{id}", method=RequestMethod.GET)
		public ResponseEntity<OrdersModel> getOrderById(@PathVariable("id") int id) {
			OrdersModel ordermodel = ordersservice.getOrderById(id);
			return new ResponseEntity<OrdersModel>(ordermodel, HttpStatus.OK);
		}
		
		//---------- Add Order-----------------------------------
		@RequestMapping(value="/AllOrders", method=RequestMethod.POST)
		public ResponseEntity<Void> addOrder(@RequestBody OrdersModel ordersmodel, UriComponentsBuilder builder) {
	        try{
			boolean flag = ordersservice.addOrder(ordersmodel);
	        if (flag == false) {
	        	System.out.println("failed to add order");
		    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        }catch(Exception e){System.out.println("Caught exception,Adding Order failed");return null;}
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(builder.path("/AllOrders/{id}").buildAndExpand(ordersmodel.getOrder_Id()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
		
		//---------- update Order my style-----------------------------------
		@RequestMapping(value="/AllOrders/{Order_Id}", method=RequestMethod.PUT)
		public ResponseEntity<String> updateOrder(@PathVariable int Order_Id, @RequestBody OrdersModel ordersmodel){
			try {
				ordersservice.updateOrder(Order_Id, ordersmodel);
				return new ResponseEntity<String>("Success",HttpStatus.OK);
			}catch (Exception e) {
				System.out.println("Error updating");
				e.printStackTrace();
			}
			return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
	/*//----Delete particular order by Order_Id if user requests(Perform this method only after executing 'DeleteOrderByOrderIdLoginId') in UserDAO-----------------------------------
		@RequestMapping(value="/DeleteOrder/{Order_Id}", method=RequestMethod.DELETE)
		public void DeleteOrder(@PathVariable("Order_Id") int Order_Id){
			ordersservice.DeleteOrder(Order_Id);
	  }*/
		
}
