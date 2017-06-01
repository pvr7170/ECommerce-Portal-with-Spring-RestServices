package com.vishal.ECommerce.Service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.ECommerce.DAO.ProductsDAO;
import com.vishal.ECommerce.DAO.UserDAO;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.ProductsModel;
import com.vishal.ECommerce.Model.UserModel;

@Service
public class ProductsService {
		
	@Autowired
	private ProductsDAO productsdao;
	
	//---------- Get All Products-----------------------------------
		public List<ProductsModel> getAllProducts(){
			return productsdao.getAllProducts();
		}
		
		//---------- Get Product by ID-----------------------------------
		public ProductsModel getProductById(int Product_Id) {
			ProductsModel obj = productsdao.getProductById(Product_Id);
			return obj;
		}

		//---------- Add Product-----------------------------------
		public void AddProduct(ProductsModel productsmodel){
			productsdao.addProduct(productsmodel);
		}	
			
		//---------- update Product by Product_Id-----------------------------------
		public void updateProduct(int Product_Id, ProductsModel productsmodel) {
			productsdao.updateProduct(Product_Id, productsmodel);
		}
		
		//---------- Delete Product by Product_Id-----------------------------------
			public void DeleteProduct(int Product_Id) {
			productsdao.deleteProduct(Product_Id);
			}
}
