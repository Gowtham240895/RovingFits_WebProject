package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.RovingFits.Model.Customer;
import com.niit.RovingFits.Model.User_Order;

@Repository("orderdao")
@Transactional
public class User_OrderDAOImpl implements IUser_OrderDAO {

	@Autowired

	SessionFactory sessionfactory;

	public boolean addOrder(User_Order Order) {
		try {
			sessionfactory.getCurrentSession().save(Order);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateOrder(User_Order Order) {
		try {
			sessionfactory.getCurrentSession().update(Order);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteOrder(User_Order Order) {
		try {
			sessionfactory.getCurrentSession().delete(Order);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<User_Order> allOrder(Customer customer) {
		try {
			ArrayList<User_Order> orderlist = (ArrayList<User_Order>) sessionfactory.getCurrentSession()
					.createCriteria(User_Order.class).add(Restrictions.eq("cust_Details", customer)).list();
			return orderlist;
		} catch (Exception e) {
			return null;
		}
	}

	public ArrayList<User_Order>  oneOrder(String order_Id) {
		try {
			ArrayList<User_Order>  order = (ArrayList<User_Order> ) sessionfactory.getCurrentSession().createCriteria(User_Order.class)
					.add(Restrictions.eq("order_Id", order_Id)).list();
			return order;
		} catch (Exception e) {
			return null;
		}
	}

}
