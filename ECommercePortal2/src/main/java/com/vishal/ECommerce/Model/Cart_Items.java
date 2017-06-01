package com.vishal.ECommerce.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="POJOCartItems")
public class Cart_Items implements Serializable { 
	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int CartLine_Id;
		
		private int CartLine_Quantity;
		private int CartLine_Price;
		
		
		@ManyToOne(cascade=CascadeType.ALL)
		private ProductsModel ProductModel;
		
		//---No need to give below declaration-------
		/*@ManyToOne
		private UserModel UserModel;*/
		
		public Cart_Items(){}
		
		public Cart_Items(int cartLine_Id, int cartLine_Quantity, int cartLine_Price, ProductsModel productModel) {
			super();
			CartLine_Id = cartLine_Id;
			CartLine_Quantity = cartLine_Quantity;
			CartLine_Price = cartLine_Price;
			ProductModel = productModel;
		}
		
		
		@Override
		public String toString() {
			return "Cart_Items [CartLine_Id=" + CartLine_Id + ", CartLine_Quantity=" + CartLine_Quantity
					+ ", CartLine_Price=" + CartLine_Price + ", ProductModel=" + ProductModel + "]";
		}




		public int getCartLine_Id() {
			return CartLine_Id;
		}


		public void setCartLine_Id(int cartLine_Id) {
			CartLine_Id = cartLine_Id;
		}


		public int getCartLine_Quantity() {
			return CartLine_Quantity;
		}


		public void setCartLine_Quantity(int cartLine_Quantity) {
			CartLine_Quantity = cartLine_Quantity;
		}


		public int getCartLine_Price() {
			return CartLine_Price;
		}


		public void setCartLine_Price(int cartLine_Price) {
			CartLine_Price = cartLine_Price;
		}


		public ProductsModel getProductModel() {
			return ProductModel;
		}


		public void setProductModel(ProductsModel productModel) {
			ProductModel = productModel;
		}
		
		
		
		
		
}

