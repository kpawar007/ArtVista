package com.artapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.artapp.model.Customer;
import com.artapp.service.CustomerServices;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServices service;
	
	@GetMapping("/showcustomerform")
	public ModelAndView display() {
		return new ModelAndView("addcustomer", "customer", new Customer());
	}

	@PostMapping("/savecustomer")
	public String saveCustomer(@Valid @ModelAttribute Customer customer) {
		String msg = service.saveCustomer(customer);
		System.out.println(msg);
		return "Success";
	}
	
	@GetMapping("/custList")
	public ModelAndView displayCustomer() {
		List<Customer> custList = service.getAllCustomers();
		return new ModelAndView("CustomerList", "cList", custList);
	}
	
	@PostMapping("/updatecust")
	public String updateCustomer(@Valid @ModelAttribute Customer customer) {
	    String msg = service.saveCustomer(customer); // password is updated here
	    System.out.println(msg);
	    return "Success";
	}
	
	@GetMapping("/editcustomer")
	public ModelAndView showUpdateForm(@RequestParam("email") String email) {
		Customer customer = service.getCustomerById(email);
		return new ModelAndView ("updatecustomer", "customer", customer);
	}
	
	@GetMapping("/deletecustomer")
	public String deleteCustomer(@RequestParam("email") String email) {
		service.deleteCustomerById(email);
		return "Success";
	}
	
	@GetMapping("/forgotpassword")
	public String showForgotPasswordForm(Model model) {
	    model.addAttribute("customer", new Customer());
	    return "forgotpassword";  // JSP page
	}

	@PostMapping("/resetpassword")
	public String resetPassword(@ModelAttribute Customer customer, Model model) {
	    // Fetch the customer using email
	    Customer existing = service.getCustomerById(customer.getEmail());

	    if (existing != null) {
	        // Update only the password
	        existing.setPassword(customer.getPassword());

	        // Reuse your save/update method
	        service.saveCustomer(existing);

	        model.addAttribute("message", "Password updated successfully!");
	        return "login"; // or any confirmation page
	    } else {
	        model.addAttribute("error", "No account found with this email.");
	        return "forgotPassword";
	    }
	}

}
