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
import com.vishal.ECommerce.Model.ProductsModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Repository.UserRepository;



@Transactional
@Repository
public class ProductsDAO {
	
	@Autowired
	UserRepository ur;
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	//---------- Get All Products-----------------------------------
		@SuppressWarnings("unchecked")
		public List<ProductsModel> getAllProducts() {
			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(ProductsModel.class);
			return criteria.list();
		}
		
		//---------- Get Product by Product_ID-----------------------------------
		public ProductsModel getProductById(int Product_Id) {
			return entityManager.find(ProductsModel.class, Product_Id);
		}
			
		//---------- Add Product-----------------------------------
		public void addProduct(ProductsModel productsmodel) {
			entityManager.persist(productsmodel);
		}
		
		//---------- update Product-----------------------------------
		public void updateProduct(int Product_Id, ProductsModel productsmodel) {
			String hql = "Update ProductsModel set Product_Name=:proname, Product_Price=:proprice, Product_Quantity=:proquan, Product_Supplier=:prosup where Product_Id=:Product_Id";
			entityManager.createQuery(hql)
						 .setParameter("proname",productsmodel.getProduct_Name())
						 .setParameter("proprice", productsmodel.getProduct_Price())
						 .setParameter("proquan", productsmodel.getProduct_Quantity())
						 .setParameter("prosup", productsmodel.getProduct_Supplier())
						 .setParameter("Product_Id", Product_Id)
						 .executeUpdate();
		}
		
		//---------- Delete Product by product_Id-----------------------------------
			public void deleteProduct(int Product_Id) {
				entityManager.remove(getProductById(Product_Id));
			}
	
}
