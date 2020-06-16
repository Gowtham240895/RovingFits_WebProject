package com.niit.RovingFits.DAO;

import com.niit.RovingFits.Model.Customer;

public interface ICustomerDAO {

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public Customer selectCustomer(String email_Id);

}
