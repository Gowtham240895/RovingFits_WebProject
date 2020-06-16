package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import com.niit.RovingFits.Model.Address;
import com.niit.RovingFits.Model.Customer;

public interface IAddressDAO {

	public boolean addAddress(Address address);

	public boolean updateAddress(Address address);

	public boolean deleteAddress(Address address);

	public ArrayList<Address> allAddress(Customer customer);

	public Address oneAddress(int address_Id);

}
