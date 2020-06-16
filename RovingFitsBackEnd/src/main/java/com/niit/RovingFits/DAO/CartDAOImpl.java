package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.RovingFits.Model.Cart;
import com.niit.RovingFits.Model.Customer;

@Repository("cartdao")
@Transactional
public class CartDAOImpl implements ICartDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean addCart(Cart cart) {
		try {
			sessionfactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateCart(Cart cart) {
		try {
			sessionfactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCart(Cart cart) {
		try {
			sessionfactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<Cart> allcart(Customer customer) {
		try {
			ArrayList<Cart> cartlist = (ArrayList<Cart>) sessionfactory.getCurrentSession().createCriteria(Cart.class)
					.add(Restrictions.eq("customer_Details", customer)).list();
			return cartlist;
		} catch (Exception e) {
			return null;
		}
	}

	public Cart oneCart(int cart_Id) {
		try {
			Cart cart = (Cart) sessionfactory.getCurrentSession().createCriteria(Cart.class)
					.add(Restrictions.eq("cart_Id", cart_Id)).uniqueResult();
			return cart;
		} catch (Exception e) {
			return null;
		}

	}
}
