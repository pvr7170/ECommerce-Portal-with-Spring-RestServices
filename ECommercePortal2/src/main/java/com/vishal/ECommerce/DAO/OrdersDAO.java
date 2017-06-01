package com.vishal.ECommerce.DAO;

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
public class OrdersDAO {
		
	@Autowired
	UserRepository ur;
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	
	//---------- Get All orders with session-----------------------------------
		@SuppressWarnings("unchecked")
		public List<OrdersModel> getAllUsers() {
			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(OrdersModel.class);
			return criteria.list();
		}
		
		//---------- Get Order by ID-----------------------------------
		public OrdersModel getOrderById(int Order_Id) {
			return entityManager.find(OrdersModel.class, Order_Id);
		}

		//---------- Add Order-----------------------------------
		public void addOrder(OrdersModel ordersmodel) {
			entityManager.persist(ordersmodel);
		}
			
		//---------- Check method for 'Add Order' if Order_Id already Exists -----------------------------------
		public boolean OrderExists(int Order_Id) {
			String hql = "FROM OrdersModel as order WHERE order.Order_Id = ?";
			int count = ((Query) entityManager.createQuery(hql).setParameter(1,Order_Id))
			              .getResultList().size();
			return count > 0 ? true : false;
		}
		
		//---------- update User-----------------------------------
		public void updateOrder(int Order_Id, OrdersModel ordersmodel) {
			String hql = "Update OrdersModel set Order_Shipdate=:osd, Order_Status=:os where Order_Id=:Order_Id";
			entityManager.createQuery(hql)
						 .setParameter("osd", ordersmodel.getOrder_Shipdate())
						 .setParameter("os", ordersmodel.getOrder_Status())
						 .setParameter("Order_Id", Order_Id)
						 .executeUpdate();
		}
		
		//----Delete particular order by Order_Id if user requests(Perform this method only after executing 'DeleteOrderByOrderIdLoginId') in UserDAO-----------------------------------
		public void deleteOrder(int Order_Id) {
			entityManager.remove(getOrderById(Order_Id));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
