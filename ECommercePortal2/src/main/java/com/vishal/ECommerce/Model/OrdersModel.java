package com.vishal.ECommerce.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="POJOOrders")
public class OrdersModel implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Order_Id;
	
	private int Order_Value;
	private String Order_Date;
	private String Order_Shipdate;
	private String Order_Status;
	
    //---NO need to give below declaration---	
	/*@ManyToOne
	private UserModel UserModel;*/
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ORDERSMODEL_PRODUCTSMODEL", joinColumns={@JoinColumn(name="Order_Id")}, inverseJoinColumns={ @JoinColumn(name="Product_Id")})
	private List<ProductsModel> ProductsModel=new ArrayList<>();
	
	public OrdersModel(){}
	
		public OrdersModel(int order_Id, int order_Value, String order_Date, String order_Shipdate, String order_Status,
			List<com.vishal.ECommerce.Model.ProductsModel> productsModel) {
		super();
		Order_Id = order_Id;
		Order_Value = order_Value;
		Order_Date = order_Date;
		Order_Shipdate = order_Shipdate;
		Order_Status = order_Status;
		ProductsModel = productsModel;
	}

	@Override
	public String toString() {
		return "OrdersModel [Order_Id=" + Order_Id + ", Order_Value=" + Order_Value + ", Order_Date=" + Order_Date
				+ ", Order_Shipdate=" + Order_Shipdate + ", Order_Status=" + Order_Status + ", ProductsModel="
				+ ProductsModel + "]";
	}



	public int getOrder_Id() {
		return Order_Id;
	}

	public void setOrder_Id(int order_Id) {
		Order_Id = order_Id;
	}

	public int getOrder_Value() {
		return Order_Value;
	}

	public void setOrder_Value(int order_Value) {
		Order_Value = order_Value;
	}

	public String getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}

	public String getOrder_Shipdate() {
		return Order_Shipdate;
	}

	public void setOrder_Shipdate(String order_Shipdate) {
		Order_Shipdate = order_Shipdate;
	}

	public String getOrder_Status() {
		return Order_Status;
	}

	public void setOrder_Status(String order_Status) {
		Order_Status = order_Status;
	}

	public List<ProductsModel> getProductsModel() {
		return ProductsModel;
	}

	public void setProductsModel(List<ProductsModel> productsModel) {
		ProductsModel = productsModel;
	}
	
	
	
}
