package com.vishal.ECommerce.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.ECommerce.DAO.Cart_ItemsDAO;
import com.vishal.ECommerce.DAO.UserDAO;
import com.vishal.ECommerce.Model.Cart_Items;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;



@Service
public class Cart_ItemsService {
		
	@Autowired
	private Cart_ItemsDAO cartdao;
	
	//---------- Get All users-----------------------------------
		public List<Cart_Items> getAllitmes(){
			return cartdao.getAllItems();
		}
		
		//---------- Get User by ID-----------------------------------
		public Cart_Items getItemById(int CartLine_Id) {
			Cart_Items obj = cartdao.getItemById(CartLine_Id);
			return obj;
		}
		
		//-----------Add cart Items by User's LoginId and CartItems model-----------------------
		public void AddItemToCart(String Login_Id, Cart_Items cartitems){
			cartdao.AddItemToCart(Login_Id, cartitems);
		}
}
