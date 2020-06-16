package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import com.niit.RovingFits.Model.Cart;
import com.niit.RovingFits.Model.Customer;

public interface ICartDAO {

	public boolean addCart(Cart cart);

	public boolean updateCart(Cart cart);

	public boolean deleteCart(Cart cart);

	public ArrayList<Cart> allcart(Customer customer);

	public Cart oneCart(int cart_id);

}
