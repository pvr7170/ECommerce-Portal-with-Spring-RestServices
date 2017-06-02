package com.vishal.ECommerce.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.ECommerce.DAO.UserDAO;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;



@Service
public class UserService {
	
	@Autowired
	private UserDAO userdao;
	
	//---------- Get All users-----------------------------------
	public List<UserModel> getAllUsers(){
		return userdao.getAllUsers();
	}
	
	//---------- Get User by ID-----------------------------------
	public UserModel getUserById(String LoginId) {
		UserModel obj = userdao.getUserById(LoginId);
		return obj;
	}
	
	//---------- Add User-----------------------------------
	public synchronized boolean addUser(UserModel usermodel){
        if (userdao.UserExists(usermodel.getLoginId())) {
            return false;
        } else {
        	userdao.addUser(usermodel);
            return true;
        }
}

	//---------- update User by ID-----------------------------------
	public void updateUser(String LoginId, UserModel usermodel) {
		userdao.updateUser(LoginId, usermodel);
	}
	
	//---------- Delete User by ID-----------------------------------
	
	public void DeleteUser(String id) {
		userdao.deleteUser(id);
		}
	
//----------------------------------------User - Order Operations---------------------------------------------------------------------------------------------	
	
	//---------- Add Order by User's Login_Id-----------------------------------
	public void AddOrderByLoginId(String Login_Id,OrdersModel ordersmodel){
		userdao.AddOrderByLoginId(Login_Id, ordersmodel);
		}
	
	/*//---------- Delete Order by User's Login_Id-----------------------------------
	public void DeleteAllOrdersByLoginId(String Login_Id,OrdersModel ordersmodel){
		userdao.DeleteAllOrdersByLoginId(Login_Id,ordersmodel);
		}*/
	
	//---------- Delete Order by Order_Id and User's Login_Id-----------------------------------
		public void DeleteOrderByOrderIdLoginId(String Login_Id,int Order_Id){
			userdao.DeleteOrderByOrderIdLoginId(Login_Id, Order_Id);
			
		}
}
   
	
	

