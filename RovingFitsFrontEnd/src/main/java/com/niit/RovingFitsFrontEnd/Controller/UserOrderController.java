package com.niit.RovingFitsFrontEnd.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.RovingFits.DAO.IAddressDAO;
import com.niit.RovingFits.DAO.ICartDAO;
import com.niit.RovingFits.DAO.IProductDAO;
import com.niit.RovingFits.DAO.IUser_OrderDAO;
import com.niit.RovingFits.Model.Address;
import com.niit.RovingFits.Model.Cart;
import com.niit.RovingFits.Model.Customer;
import com.niit.RovingFits.Model.Product;
import com.niit.RovingFits.Model.User_Order;

@Controller
@RequestMapping("/user")
public class UserOrderController {

	@Autowired
	IAddressDAO addressdao;

	@Autowired
	IUser_OrderDAO userordersdao;
	@Autowired
	IProductDAO productdao;

	@Autowired
	ICartDAO cartdao;

	@RequestMapping("/placeorder")
	String placeOrder(@RequestParam("addressid") int addressid, HttpSession session, Model model) {

		User_Order userorder = new User_Order();
		ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cartinfo");
		Address address = addressdao.oneAddress(addressid);
		Customer customer = (Customer) session.getAttribute("custdetails");
		String orderid = "OD" + UUID.randomUUID().getMostSignificantBits();
		Iterator<Cart> cartIterator = cartlist.iterator();
		while (cartIterator.hasNext()) {
			Cart cart = (Cart) cartIterator.next();
			userorder.setAddress(address);
			userorder.setOrder_Date(new Date());
			userorder.setCustomer_Details(customer);
			userorder.setOrder_Id(orderid);
			userorder.setProduct_Details(cart.getProduct_Details());
			userorder.setProduct_Quantity(cart.getProduct_Quantity());
			userorder.setTotal(Float.parseFloat(session.getAttribute("total").toString()));
			Product p = cart.getProduct_Details();
			if (p.getProduct_Stock() >= cart.getProduct_Quantity() && userordersdao.addOrder(userorder)) {

				p.setProduct_Stock(p.getProduct_Stock() - cart.getProduct_Quantity());
				productdao.updateProduct(p);
				cartdao.deleteCart(cart);
			}
		}
		cartlist = cartdao.allcart(customer);
		session.setAttribute("total", 0);
		session.setAttribute("cartinfo", cartlist);
		return "redirect:/user/viewallorders";

	}

	@RequestMapping("/viewallorders")
	String viewOrders(HttpSession session, Model model) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		ArrayList<User_Order> orders = userordersdao.allOrder(cust);
		model.addAttribute("orderlist", orders);
		model.addAttribute("orderpage", true);
		return "index";

	}

	@RequestMapping("/viewdetails")
	String viewDetails(@RequestParam("oid") String orderid, Model model) {

		ArrayList<User_Order> orders = userordersdao.oneOrder(orderid);
		model.addAttribute("orderlist", orders);
		model.addAttribute("oneorderspage", true);
		return "index";

	}

}