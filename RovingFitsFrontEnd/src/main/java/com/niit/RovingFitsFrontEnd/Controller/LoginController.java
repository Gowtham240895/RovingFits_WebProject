package com.niit.RovingFitsFrontEnd.Controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.RovingFits.DAO.ICartDAO;
import com.niit.RovingFits.DAO.ICustomerDAO;
import com.niit.RovingFits.Model.Cart;
import com.niit.RovingFits.Model.Customer;

@Controller
public class LoginController {
	@Autowired
	ICustomerDAO customerdao;

	@Autowired
	ICartDAO cartdao;

	@RequestMapping("/login")

	String LoginPage(@RequestParam(value = "error", required = false, defaultValue = "false") boolean error,
			Model model) {
		if (error) {
			model.addAttribute("info", true);
			model.addAttribute("message", "user name password incorrect");

		} else {
			model.addAttribute("info", false);
			model.addAttribute("message", "");
		}
		model.addAttribute("loginpage", true);
		model.addAttribute("tittle", "RovingFits--login");
		return "index";
	}

	@RequestMapping("/loginsuccess")
	String loginSuccess(Model model, HttpSession session) {
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		if (role.equals("[ROLE_ADMIN]")) {
			System.out.println("admin controller");
			session.setAttribute("username", "ADMINSTRATOR");
			System.out.println("Admin login");
			session.setAttribute("adminrole", true);
			session.setAttribute("userrole", false);
		} else {
			Customer customer = customerdao.selectCustomer(userid);
			session.setAttribute("custdetails", customer);
			session.setAttribute("username", customer.getCustomer_Name().toUpperCase());
			System.out.println("User login");
			session.setAttribute("userrole", true);
			session.setAttribute("adminrole", false);
			ArrayList<Cart> cartlist = cartdao.allcart(customer);
			session.setAttribute("cartinfo", cartlist);
			session.setAttribute("cartqty", cartlist.size());
			if (session.getAttribute("pid") != null) {
				int pid = Integer.parseInt(session.getAttribute("pid").toString());
				int qty = Integer.parseInt(session.getAttribute("qty").toString());
				return "redirect:/addtocart?productid=" + pid + "&quantity=" + qty;
			}
		}
		model.addAttribute("indexpage", true);
		return "index";
	}
}