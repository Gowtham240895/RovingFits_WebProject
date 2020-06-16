package com.niit.RovingFits.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.RovingFits.Model.Customer;
import com.niit.RovingFits.Model.Customer_Crd;

@Repository("customerdao")
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {

	@Autowired

	SessionFactory sessionfactory;

	public boolean addCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().save(customer);
			Customer_Crd cred=new Customer_Crd();
			cred.setCustomer_Crd_Email(customer.getCustomer_Email());
			cred.setCustomer_Crd_Password(customer.getCustomer_Password());
			cred.setCustomer_Crd_status("false");
			cred.setCustomer_Crd_Role("ROLE_CUSTOMER");
			sessionfactory.getCurrentSession().save(cred);
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}

	public boolean updateCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Customer selectCustomer(String customer_Email) {

		try {

			Customer customer = (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
					.add(Restrictions.eq("customer_Email", customer_Email)).uniqueResult();

			return customer;
		} catch (Exception e) {
			return null;
		}
	}
}
