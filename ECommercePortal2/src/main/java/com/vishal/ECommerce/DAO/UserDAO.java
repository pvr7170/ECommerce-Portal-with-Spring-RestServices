package com.vishal.ECommerce.DAO;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Repository.UserRepository;



@Transactional
@Repository
public class UserDAO {
	
	@Autowired
	UserRepository ur;
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Autowired
	OrdersDAO orderdao;
	
	
	OrdersModel ordersmodel=new OrdersModel();
	
	//---------- Get All users by HQL-----------------------------------
	@SuppressWarnings("unchecked")
	public List<UserModel> getAllUsers() {
		String hql = "FROM UserModel";
		return (List<UserModel>) entityManager.createQuery(hql).getResultList();
		
	}
	
	
	/*//---------- Get All users-----------------------------------
	@SuppressWarnings("unchecked")
	public List<UserModel> getAllUsers() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(UserModel.class);
		return criteria.list();
	}*/
	
	//---------- Get User by ID-----------------------------------
	public UserModel getUserById(String LoginId) {
		return entityManager.find(UserModel.class, LoginId);
	}
	
	
	//---------- Add User-----------------------------------
	public void addUser(UserModel usermodel) {
		entityManager.persist(usermodel);
	}
	//---------- Check method for 'Add User' If Login_Id already Exists -----------------------------------
			public boolean UserExists(String LoginId) {
			String hql = "FROM UserModel as user WHERE user.LoginId = ?";
			int count = ((Query) entityManager.createQuery(hql).setParameter(1,LoginId))
			              .getResultList().size();
			return count > 0 ? true : false;
		}
	
	//---------- update User-----------------------------------
	public void updateUser(String LoginId, UserModel usermodel) {
		String hql = "Update UserModel set Password=:pwd, FirstName=:fn,LastName=:ln, Address=:ad where LoginId=:LoginId";
		entityManager.createQuery(hql)
					 .setParameter("pwd",usermodel.getPassword())
					 .setParameter("fn", usermodel.getFirstName())
					 .setParameter("ln", usermodel.getLastName())
					 .setParameter("ad", usermodel.getAddress())
					 .setParameter("LoginId", LoginId)
					 .executeUpdate();
	}
	
	//---------- Delete User My style-----------------------------------
		public void deleteUser(String LoginId) {
			entityManager.remove(getUserById(LoginId));
		}
		
//----------------------------------------User - Order Operations---------------------------------------------------------------------------------------------
		
		//---------- Add Order by User's Login_Id-----------------------------------
				public void AddOrderByLoginId(String Login_Id,OrdersModel ordersmodel){
					UserModel user = entityManager.find(UserModel.class, Login_Id);			
					user.getOrdersModel().add(ordersmodel);
				}
	
		/*//---------- Delete All Orders by User's Login_Id-----------------------------------
				public void DeleteAllOrdersByLoginId(String Login_Id,OrdersModel ordersmodel){
					UserModel user = entityManager.find(UserModel.class, Login_Id);	
					user.getOrdersModel().remove(ordersmodel);
					entityManager.merge(user);
			}*/
				
		/*//---------- Delete Order by Order_Id and User's Login_Id-----------------------------------	
				public void DeleteOrderByOrderIdLoginId(String Login_Id,int Order_Id){
					UserModel user = entityManager.find(UserModel.class, Login_Id);	
					user.getOrdersModel().remove(Order_Id);
					entityManager.merge(user);
				}*/
	
}
