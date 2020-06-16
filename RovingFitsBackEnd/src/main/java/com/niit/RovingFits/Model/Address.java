package com.niit.RovingFits.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int address_Id;
	
	@Column(nullable = false)
	String address_Name;
	
	@Column(nullable = false)
	String address_Line1;
	
	@Column(nullable = false)
	String address_Line2;
	
	@Column(nullable = false)
	String address_Area;
	
	@ManyToOne
	Customer address_customer;
	
	@Column(nullable = false)
	int address_pincode;

	public int getaddress_Id() {
		return address_Id;
	}

	public void setaddress_Id(int address_Id) {
		this.address_Id = address_Id;
	}

	public String getAddress_Name() {
		return address_Name;
	}

	public void setAddress_Name(String address_Name) {
		this.address_Name = address_Name;
	}

	public String getAddress_Line1() {
		return address_Line1;
	}

	public void setAddress_Line1(String address_Line1) {
		this.address_Line1 = address_Line1;
	}

	public String getAddress_Line2() {
		return address_Line2;
	}

	public void setAddress_Line2(String address_Line2) {
		this.address_Line2 = address_Line2;
	}

	public String getAddress_Area() {
		return address_Area;
	}

	public void setAddress_Area(String address_Area) {
		this.address_Area = address_Area;
	}

	public Customer getAddress_customer() {
		return address_customer;
	}

	public void setAddress_customer(Customer address_customer) {
		this.address_customer = address_customer;
	}

	public int getAddress_pincode() {
		return address_pincode;
	}

	public void setAddress_pincode(int address_pincode) {
		this.address_pincode = address_pincode;
	}

}
