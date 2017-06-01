package com.vishal.ECommerce.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="POJOUsers")
public class UserModel implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@Id
	private String LoginId;
	
	private String Password;
	private String FirstName;
	private String LastName;
	private String Address;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USERMODEL_ORDERMODEL", joinColumns={@JoinColumn(name="LoginId")}, inverseJoinColumns={ @JoinColumn(name="Order_Id")})
	private List<OrdersModel> OrdersModel=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USERMODEL_CARTitemsMODEL", joinColumns={@JoinColumn(name="LoginId")}, inverseJoinColumns={ @JoinColumn(name="CartLine_Id")})
	private List<Cart_Items> CartItems=new ArrayList<>(); 
	
	public UserModel(){}
	
	
	public UserModel(String loginId, String password, String firstName, String lastName, String address,
			List<com.vishal.ECommerce.Model.OrdersModel> ordersModel, List<Cart_Items> cartItems) {
		super();
		LoginId = loginId;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		OrdersModel = ordersModel;
		CartItems = cartItems;
	}
	
	
	@Override
	public String toString() {
		return "UserModel [LoginId=" + LoginId + ", Password=" + Password + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", Address=" + Address + ", OrdersModel=" + OrdersModel + ", CartItems=" + CartItems + "]";
	}


	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<OrdersModel> getOrdersModel() {
		return OrdersModel;
	}

	public void setOrdersModel(List<OrdersModel> ordersModel) {
		OrdersModel = ordersModel;
	}

	public List<Cart_Items> getCartItems() {
		return CartItems;
	}

	public void setCartItems(List<Cart_Items> cartItems) {
		CartItems = cartItems;
	}

	
}
