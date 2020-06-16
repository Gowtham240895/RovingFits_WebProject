package com.niit.RovingFits.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer_Crd {
	@Id
	@Column(nullable = false)
	String customer_Crd_Email;
	@Column(nullable = false)
	String customer_Crd_Password;
	@Column(nullable = false)
	String customer_Crd_Role;
	@Column(nullable = false)
	String customer_Crd_status;

	public String getCustomer_Crd_Email() {
		return customer_Crd_Email;
	}

	public void setCustomer_Crd_Email(String customer_Crd_Email) {
		this.customer_Crd_Email = customer_Crd_Email;
	}

	public String getCustomer_Crd_Password() {
		return customer_Crd_Password;
	}

	public void setCustomer_Crd_Password(String customer_Crd_Password) {
		this.customer_Crd_Password = customer_Crd_Password;
	}

	public String getCustomer_Crd_Role() {
		return customer_Crd_Role;
	}

	public void setCustomer_Crd_Role(String customer_Crd_Role) {
		this.customer_Crd_Role = customer_Crd_Role;
	}

	public String getCustomer_Crd_status() {
		return customer_Crd_status;
	}

	public void setCustomer_Crd_status(String customer_Crd_status) {
		this.customer_Crd_status = customer_Crd_status;
	}
}