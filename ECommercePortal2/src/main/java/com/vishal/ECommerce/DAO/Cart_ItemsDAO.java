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
		public String AddItemToCart(String Login_Id, Cart_Items cartitems) {

			
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
			
			return hql;
		}
		
		//---------------Update Cart Item------------------------------------------
		public void updateCart(Cart_Items cartitems,int CartLine_Id) {
			int q = cartitems.getCartLine_Quantity();
			int p = q*cartitems.getProductModel().getProduct_Price();
			String hql = "Update Cart_Items set CartLine_Quantity=:quantity, CartLine_Price=:p where CartLine_Id=:line_id";
			entityManager.createQuery(hql)
						 .setParameter("quantity",q)
						 .setParameter("p", p)
						 .setParameter("line_id", CartLine_Id)
						 .executeUpdate();

		}
		
		//-------------Remove user's Cart Item--------------------------------------
		public void removeItemfromCart(String Login_Id, int CartLine_Id) {
			String hql = "From UserModel where Login_Id=:Login_Id";
			UserModel usermodel = (UserModel) entityManager.createQuery(hql).setParameter("Login_Id", Login_Id).getSingleResult();
			List<Cart_Items> list = usermodel.getCartItems();

			Cart_Items line = (Cart_Items) entityManager.createQuery("From Cart_Items where CartLine_Id=:line_id")
					.setParameter("line_id", CartLine_Id).getSingleResult();
			list.remove(line);
			usermodel.setCartItems(list);
			
			entityManager.merge(usermodel);
		}
		
		//-------------Delete from Cart Table after above method-----------------------------
				public void deleteCartItem(int CartLine_Id) {
					entityManager.remove(getItemById(CartLine_Id));
				}
				
		//--------------Delete product from cart------------------------------------------
			public void DeleteCartRelationWithProduct(int CartLine_Id)	{
				
				Cart_Items items = entityManager.find(Cart_Items.class, CartLine_Id);	
				//ProductsModel prod = entityManager.find(ProductsModel.class, Product_Id);
				
				items.setProductModel(new ProductsModel());
				
				entityManager.merge(items);
			}

}
