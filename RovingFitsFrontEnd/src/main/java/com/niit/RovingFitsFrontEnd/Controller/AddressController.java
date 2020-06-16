package com.niit.RovingFitsFrontEnd.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.RovingFits.DAO.IAddressDAO;
import com.niit.RovingFits.Model.Address;
import com.niit.RovingFits.Model.Customer;

@Controller
@RequestMapping("/user")
public class AddressController {
	@Autowired
	IAddressDAO addressdao;

	@RequestMapping("/selectaddress")
	String addressPage(Model model, HttpSession session) {

		Customer cust = (Customer) session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		model.addAttribute("addressobject", new Address());
		return "index";
	}

	@RequestMapping("/addaddress")
	String addaddressPage(@RequestParam Map<String, String> addressmodel, Model model, HttpSession session) {
		System.out.println(addressmodel.get("pincode"));

		Customer cust = (Customer) session.getAttribute("custdetails");
		Address address = new Address();
		address.setAddress_Area(addressmodel.get("area"));
		address.setAddress_customer(cust);
		address.setAddress_Line1(addressmodel.get("line1"));
		address.setAddress_Line2(addressmodel.get("line2"));
		address.setAddress_Name(addressmodel.get("name"));
		address.setAddress_pincode(Integer.parseInt(addressmodel.get("pincode")));
		System.out.println(addressmodel.get("pincode"));
		try {
			if (addressdao.addAddress(address)) {
				model.addAttribute("info", true);
				model.addAttribute("message", "Address Inserted");

			} else {
				model.addAttribute("info", true);
				model.addAttribute("message", "Address Not  Inserted");
			}
		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "Address Not  Inserted");
		}
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		return "index";
	}

	@RequestMapping("/deleteaddress")
	String deleteAddress(@RequestParam("addressid") int addressid, Model model, HttpSession session) {
		try {

			if (addressdao.deleteAddress(addressdao.oneAddress(addressid))) {
				model.addAttribute("info", true);
				model.addAttribute("message", "Data Deleted");
			} else {
				model.addAttribute("info", true);
				model.addAttribute("message", "Data Not Deleted");
			}

		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "Data Deleted");
		}

		Customer cust = (Customer) session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));

		return "index";
	}

	@RequestMapping("/editaddress")
	String editAddress(@RequestParam("addressid") int addressid, Model model, HttpSession session) {
		model.addAttribute("edit", true);
		Customer cust = (Customer) session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		model.addAttribute("addressobject", addressdao.oneAddress(addressid));
		System.out.println(addressdao.oneAddress(addressid).getAddress_Area());
		return "index";
	}

	@RequestMapping("/updateaddress")
	String updateaddressPage(@RequestParam Map<String, String> addressmodel, Model model, HttpSession session) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		Address address = new Address();
		address.setaddress_Id(Integer.parseInt(addressmodel.get("addressid")));
		address.setAddress_Area(addressmodel.get("area"));
		address.setAddress_customer(cust);
		address.setAddress_Line1(addressmodel.get("line1"));
		address.setAddress_Line2(addressmodel.get("line2"));
		address.setAddress_Name(addressmodel.get("name"));
		address.setAddress_pincode(Integer.parseInt(addressmodel.get("pincode")));
		try {
			if (addressdao.updateAddress(address)) {
				model.addAttribute("info", true);
				model.addAttribute("message", "Address Inserted");

			} else {
				model.addAttribute("info", true);
				model.addAttribute("message", "Address Not  Inserted");
			}
		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "Address Not  Inserted");
		}
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		return "index";
	}

}