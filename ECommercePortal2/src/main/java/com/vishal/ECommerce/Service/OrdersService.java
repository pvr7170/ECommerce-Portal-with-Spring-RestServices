package com.vishal.ECommerce.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.ECommerce.DAO.OrdersDAO;
import com.vishal.ECommerce.DAO.UserDAO;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;



@Service
public class OrdersService {
	
	@Autowired
	private OrdersDAO ordersdao;
	
	//---------- Get All orders-----------------------------------
	public List<OrdersModel> getAllUsers(){
		return ordersdao.getAllUsers();
	}

	//---------- Get order by ID-----------------------------------
		public OrdersModel getOrderById(int Order_Id) {
			OrdersModel obj = ordersdao.getOrderById(Order_Id);
			return obj;
		}
		
		//---------- Add Order-----------------------------------
		public synchronized boolean addOrder(OrdersModel ordersmodel){
	        if (ordersdao.OrderExists(ordersmodel.getOrder_Id())) {
	            return false;
	        } else {
	        	ordersdao.addOrder(ordersmodel);
	            return true;
	        }
	}
		
		//---------- update Order by ID-----------------------------------
		public void updateOrder(int Order_Id, OrdersModel ordersmodel) {
			ordersdao.updateOrder(Order_Id, ordersmodel);
		}

		//----Delete particular order by Order_Id if user requests(Perform this method only after executing 'DeleteOrderByOrderIdLoginId') in UserDAO-----------------------------------	
		public void DeleteOrder(int Order_Id) {
			ordersdao.deleteOrder(Order_Id);
			}
}
