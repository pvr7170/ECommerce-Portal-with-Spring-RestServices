package com.vishal.ECommerce.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POJOProducts")
public class ProductsModel implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Product_Id;
	
	private String Product_Name;
	private int Product_Price;
	private String Product_Supplier;
	
	public ProductsModel(){}
	
	
	

	public ProductsModel(int product_Id, String product_Name, int product_Price, String product_Supplier) {
		super();
		Product_Id = product_Id;
		Product_Name = product_Name;
		Product_Price = product_Price;
		Product_Supplier = product_Supplier;
	}




	@Override
	public String toString() {
		return "ProductsModel [Product_Id=" + Product_Id + ", Product_Name=" + Product_Name + ", Product_Price="
				+ Product_Price + ", Product_Supplier=" + Product_Supplier + "]";
	}




	public int getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public int getProduct_Price() {
		return Product_Price;
	}

	public void setProduct_Price(int product_Price) {
		Product_Price = product_Price;
	}

	public String getProduct_Supplier() {
		return Product_Supplier;
	}

	public void setProduct_Supplier(String product_Supplier) {
		Product_Supplier = product_Supplier;
	}
	
	

}
