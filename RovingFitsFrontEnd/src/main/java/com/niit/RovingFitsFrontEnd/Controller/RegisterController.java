package com.niit.RovingFitsFrontEnd.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.RovingFits.DAO.ICustomerDAO;
import com.niit.RovingFits.Model.Customer;

@Controller
public class RegisterController {

	@Autowired
	ICustomerDAO customerdao;

	@RequestMapping("/register")
	String RegisterPage(Model model) {
		model.addAttribute("registerpage", true);
		model.addAttribute("customerobject", new Customer());
		model.addAttribute("title", "register");
		return "index";
	}

	@RequestMapping("/addcustomer")
	String addRegisterPage(@Valid @ModelAttribute("customerobject")Customer customer, BindingResult br, Model model) 
	{
		try {
			if (br.hasErrors()) {
				model.addAttribute("info", true);
				model.addAttribute("message", "Please Enter Data In Correct Format");
				model.addAttribute("customerobject", customer);// this line will help in populating errors
				System.out.println("Has Errors");

			}
			else 
			{
				if (customerdao.addCustomer(customer)) 
				{
					model.addAttribute("customerobject", new Customer());
					model.addAttribute("info", true);
					model.addAttribute("message", "Customer Added");
					System.out.println("Done");
				} 
				else 
				{
					model.addAttribute("customerobject", customer);
					model.addAttribute("info", true);
					model.addAttribute("message", "Check Data");
					System.out.println("Failure");
				}

			}
		} 
		
		catch (Exception e) 
		{
			model.addAttribute("customerobject", customer);
			model.addAttribute("info", true);
			model.addAttribute("message", "Check Data");
			System.out.println("Failure");

		}
		model.addAttribute("registerpage", true);
		model.addAttribute("title", "RovingFits--Customer");
		
		return "index";
	}
}

