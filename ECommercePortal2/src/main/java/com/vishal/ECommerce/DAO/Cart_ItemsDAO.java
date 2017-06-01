/*package com.vishal.ECommerce.DAO;

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

import com.vishal.ECommerce.Model.Cart_Items;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Repository.UserRepository;

@Transactional
@Repository
public class Cart_ItemsDAO {
		
	@Autowired
	UserRepository ur;
	
	@PersistenceContext	
	private EntityManager entityManager;
		
	//---------- Get All Cart Items by HQL-----------------------------------
		@SuppressWarnings("unchecked")
		public List<Cart_Items> getAllItems() {
			String hql = "FROM Cart_Items";
			return (List<Cart_Items>) entityManager.createQuery(hql).getResultList();
			}
		
		//---------- Get Cart Item by ID-----------------------------------
		public Cart_Items getItemById(int CartLine_Id) {
			return entityManager.find(Cart_Items.class, CartLine_Id);
		}
			
			
		

}
*/