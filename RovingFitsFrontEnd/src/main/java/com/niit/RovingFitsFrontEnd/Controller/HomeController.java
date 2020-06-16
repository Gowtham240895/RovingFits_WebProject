package com.niit.RovingFitsFrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.RovingFits.DAO.IProductDAO;

@Controller
public class HomeController {
	@Autowired
	IProductDAO productdao;
	
	@RequestMapping(value = { "/", "/home" })
	String IndexPage(Model model) {
		model.addAttribute("indexpage", true);
		model.addAttribute("title", "RovingFits");
		return "index";
	}

	@RequestMapping("/aboutus")
	String abouotusPage(Model model) {
		model.addAttribute("aboutuspage", true);
		model.addAttribute("title", "AboutUs");
		return "index";
	}

	@RequestMapping("/contactus")
	String contactusPage(Model model) {
		model.addAttribute("contactus", true);
		model.addAttribute("title", "ContactUs");
		return "index";
	}
		@RequestMapping("/allproduct")
	String DisplayProduct(Model model)
	{
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("allproductpage",true);
		return "index";
	}
	 
	@RequestMapping("/oneproduct")
	String ProductDetails(@RequestParam("prodid") int prodid, Model model)
	{
		
		model.addAttribute("prod", productdao.oneProduct(prodid));
		model.addAttribute("productdetails",true);
		 model.addAttribute("tittle","RovingFits--product");
		return "index";
		
	}

}
