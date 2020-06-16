package com.niit.RovingFits.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User_Order {
	
	@Id
	String order_Id;
	
	@ManyToOne
	Product product_Details;
	
	int product_Quantity;
	
	@ManyToOne
	Customer customer_Details;
	
	@ManyToOne
	Address address;
	
	@Column(nullable = false)
	float Total;
	
	@Temporal(TemporalType.DATE)
	Date order_Date;

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public Product getProduct_Details() {
		return product_Details;
	}

	public void setProduct_Details(Product product_Details) {
		this.product_Details = product_Details;
	}

	public int getProduct_Quantity() {
		return product_Quantity;
	}

	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}

	public Customer getCustomer_Details() {
		return customer_Details;
	}

	public void setCustomer_Details(Customer customer_Details) {
		this.customer_Details = customer_Details;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}
}
