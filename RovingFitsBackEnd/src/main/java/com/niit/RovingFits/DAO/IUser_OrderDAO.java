package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import com.niit.RovingFits.Model.Customer;
import com.niit.RovingFits.Model.User_Order;

public interface IUser_OrderDAO {

	public boolean addOrder(User_Order Order);

	public boolean updateOrder(User_Order Order);

	public boolean deleteOrder(User_Order Order);

	public ArrayList<User_Order> allOrder(Customer customer_crt_Email);

	public ArrayList<User_Order> oneOrder(String order_Id);

}
