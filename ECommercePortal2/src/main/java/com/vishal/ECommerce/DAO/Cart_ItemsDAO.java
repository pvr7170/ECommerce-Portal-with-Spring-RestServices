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

import com.vishal.ECommerce.Model.Cart_Items;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.ProductsModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Repository.UserRepository;

@Transactional
@Repository
public class Cart_ItemsDAO {
	
	
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
			
		//------------Add Cart Item-----------------------------------------------
		public void AddItemToCart(String Login_Id, Cart_Items cartitems) {

			
			String hql = "From ProductsModel where Product_Name=:pname and Product_Supplier=:psupplier and Product_Price=:pprice";
			ProductsModel productmodel = (ProductsModel) entityManager.createQuery(hql).setParameter("pname", cartitems.getProductModel().getProduct_Name())
					.setParameter("psupplier",cartitems.getProductModel().getProduct_Supplier())
					.setParameter("pprice",cartitems.getProductModel().getProduct_Price()).getSingleResult();
			
			String hql1 = "From UserModel where LoginId=:LoginId";
			UserModel usermodel = (UserModel) entityManager.createQuery(hql1).setParameter("LoginId", Login_Id).getSingleResult();
			
			int id=0;
			Cart_Items line1=null;
			List<Cart_Items> list = usermodel.getCartItems();
			for (Cart_Items line_Items : list) {
				if(line_Items.getProductModel().getProduct_Id() == cartitems.getProductModel().getProduct_Id()){
					id=line_Items.getCartLine_Id();
					line1=line_Items;
				}
			}
			if (productmodel != null && id==0) {
				int p =cartitems.getCartLine_Quantity() * cartitems.getProductModel().getProduct_Price();
				cartitems.setCartLine_Price(p);
				
				list.add(cartitems);
				usermodel.setCartItems(list);
				entityManager.merge(usermodel);
			}
			
			else if(productmodel!=null && id!=0){
				entityManager.createQuery("Update Cart_Items set CartLine_Quantity=:q + :q1, CartLine_Price = :p1 + :p2 where CartLine_Id=:id")
							 .setParameter("q", line1.getCartLine_Quantity())
							 .setParameter("q1", cartitems.getCartLine_Quantity())
							 .setParameter("p1", line1.getCartLine_Price())
							 .setParameter("p2", cartitems.getCartLine_Quantity() * productmodel.getProduct_Price())
							 .setParameter("id", id)
							 .executeUpdate();
			}
			else{
				System.out.println("The entered product does not exist in database");
			}
		}
		

}
