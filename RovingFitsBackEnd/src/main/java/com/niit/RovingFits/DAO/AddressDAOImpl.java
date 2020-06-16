package com.niit.RovingFits.DAO;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.RovingFits.Model.Address;
import com.niit.RovingFits.Model.Customer;

@Repository("addressdao")
@Transactional
public class AddressDAOImpl implements IAddressDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean addAddress(Address address) {
		try {
			sessionfactory.getCurrentSession().save(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateAddress(Address address) {

		try {
			sessionfactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteAddress(Address address) {

		try {
			sessionfactory.getCurrentSession().delete(address);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public ArrayList<Address> allAddress(Customer customer) {
		try {
			/*
			 * WHEN WE HAVE PARAMETER IN MY SELECT METHOD
			 * 
			 * THE THERE SHOULD BE RESTRICTION STATEMENT WHEN WE HAVE TO USE RESTRICTION THE
			 * WE WILL USE CREATE CRITETRIA
			 */
			ArrayList<Address> addresslist = (ArrayList<Address>) sessionfactory.getCurrentSession()
					.createCriteria(Address.class).add(Restrictions.eq("address_customer", customer)).list();
			return addresslist;
		} catch (Exception e) {
			return null;
		}

	}

	public Address oneAddress(int address_Id) {
		try {
			Address address = (Address) sessionfactory.getCurrentSession().createCriteria(Address.class)
					.add(Restrictions.eq("address_Id", address_Id)).uniqueResult();
			return address;
		} catch (Exception e) {
			return null;
		}
	}

}
