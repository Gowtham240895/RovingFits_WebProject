package com.niit.RovingFitsFrontEnd.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.RovingFits.DAO.ICartDAO;
import com.niit.RovingFits.DAO.IProductDAO;
import com.niit.RovingFits.Model.Cart;
import com.niit.RovingFits.Model.Customer;
import com.niit.RovingFits.Model.Product;

@Controller
public class CartController {
	@Autowired
	IProductDAO productdao;

	@Autowired
	ICartDAO cartdao;

	@RequestMapping("/addtocart")

	String addToCart(@RequestParam("product_Id") int pid,
			@RequestParam(required = false, value = "quantity", defaultValue = "1") int qty,
			@RequestParam(value = "cartpage", required = false, defaultValue = "false") boolean cartpage, Model model,
			HttpSession session) {
		Customer c = (Customer) session.getAttribute("custdetails");
		if (session.getAttribute("cartinfo") == null) {
			System.out.println("Data Checking1");
			session.setAttribute("pid", pid);
			session.setAttribute("qty", qty);
			model.addAttribute("loginpage", true);
		} else {
			Cart item = new Cart();

			Product p = productdao.oneProduct(pid);
			ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cartinfo");
			if (cartlist.isEmpty()) {
				item.setCustomer_Details(c);
				item.setProduct_Details(p);
				System.out.println("Data Checking2");
				if (p.getProduct_Stock() >= qty) {
					item.setProduct_Quantity(qty);
				} else {
					item.setProduct_Quantity(1);
					model.addAttribute("error", true);
					model.addAttribute("message", "Stock insufficent");
					model.addAttribute("pid", p.getProduct_Id());
				}
				cartdao.addCart(item);
			} else {
				int flag = 1;
				Iterator<Cart> cartitem = cartlist.listIterator();
				while (cartitem.hasNext()) {
					Cart cart = (Cart) cartitem.next();
					if (cart.getProduct_Details().getProduct_Id() == pid) {
						if (cartpage) {
							if (qty > p.getProduct_Stock()) {
								model.addAttribute("error", true);
								model.addAttribute("message", "Stock insufficent");
								model.addAttribute("pid", p.getProduct_Id());
							} else {
								cart.setProduct_Quantity(qty);
								cartdao.updateCart(cart);
							}
						} else {
							int oldqty = cart.getProduct_Quantity();
							int newqty = oldqty + qty;
							if (newqty > p.getProduct_Stock())

							{
								model.addAttribute("error", true);
								model.addAttribute("message", "Stock insufficent");
								model.addAttribute("pid", p.getProduct_Id());
							} else {
								cart.setProduct_Quantity(newqty);
								cartdao.updateCart(cart);
							}
						}

						flag = 0;
						break;
					}
				}
				if (flag == 1) {
					item.setCustomer_Details(c);
					item.setProduct_Details(p);
					if (p.getProduct_Stock() >= qty) {
						item.setProduct_Quantity(qty);
					} else {
						model.addAttribute("error", true);
						model.addAttribute("message", "Stock insufficent");
						model.addAttribute("pid", p.getProduct_Id());
					}
					cartdao.addCart(item);
				}
			}
			float total = 0;
			cartlist = cartdao.allcart(c);
			Iterator<Cart> cartiterator = cartlist.iterator();
			while (cartiterator.hasNext()) {
				Cart cart = (Cart) cartiterator.next();
				total = total + (cart.getProduct_Quantity() * cart.getProduct_Details().getProduct_Price());
			}
			session.setAttribute("total", total);
			session.setAttribute("cartinfo", cartlist);
			model.addAttribute("cartpage", true);
		}
		return "index";

	}

	@RequestMapping("/user/viewcart")
	String viewCart(HttpSession session, Model model) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		if (session.getAttribute("cartinfo") == null) {
			ArrayList<Cart> cartlist = cartdao.allcart(cust);
			float total = 0;
			Iterator<Cart> cartiterator = cartlist.iterator();
			while (cartiterator.hasNext()) {
				Cart cart = (Cart) cartiterator.next();
				total = total + (cart.getProduct_Quantity() * cart.getProduct_Details().getProduct_Price());
			}
			session.setAttribute("total", total);
			session.setAttribute("cartinfo", cartlist);
			session.setAttribute("cartinfo", cartdao.allcart(cust));
		}

		model.addAttribute("cartpage", true);
		return "index";

	}

	@RequestMapping("/user/deleteitem")
	String deleteCart(@RequestParam("cartid") int cartid, Model model, HttpSession session) {
		System.out.println(cartid);
		Customer cust = (Customer) session.getAttribute("custdetails");
		cartdao.deleteCart(cartdao.oneCart(cartid));
		session.setAttribute("cartinfo", cartdao.allcart(cust));
		model.addAttribute("cartpage", true);
		return "index";

	}

}