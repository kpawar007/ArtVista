	package com.artapp.controller;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.servlet.ModelAndView;
	
	import com.artapp.model.Customer;
	import com.artapp.model.Orders;
	import com.artapp.repository.CartRepository;
	import com.artapp.repository.CustomerRepository;
	import com.artapp.service.OrderServices;
	
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpSession;
	
	
	@Controller
	public class OrderController {
		@Autowired
		private CartRepository crepo;
		
		@Autowired
		private CustomerRepository cusrepo;
		
		@Autowired
		private OrderServices service;
		
		
		@GetMapping("/placeOrder")
	public ModelAndView displayOrder(HttpSession session) {
		String emailId = (String) session.getAttribute("customerEmailID");
		double totalprice=crepo.getTotalPriceSumByEmail(emailId);
		return new ModelAndView("Orders","tprice",totalprice);
	}
	
	
	@PostMapping("/saveOrder")
	public ModelAndView saveOrder(HttpServletRequest req, HttpSession session) {
		String emailId = (String) session.getAttribute("customerEmailID");
		Customer cust=cusrepo.findByEmail(emailId);
		String city=req.getParameter("City");
		String state=req.getParameter("State");
		String country=req.getParameter("Country");
		int pin=Integer.parseInt(req.getParameter("pincode"));
		String rname=req.getParameter("receiverName");
		String remail=req.getParameter("reciveremail");
		Long cphone=Long.parseLong(req.getParameter("reciverphone"));
		double tprice =Double.parseDouble(req.getParameter("totalPrice"));
		Orders order=new Orders(cust, tprice, city, state, country, pin, rname, remail, cphone);
		Orders order1=service.saveOrder(order);
		
		return new ModelAndView("Payment","order",order1);
	
	}
			
	    @GetMapping("/send")
	    public ModelAndView sendEmail(HttpServletRequest req) {
	    	String emailID=req.getParameter("emailId");
	    	double totalprice=Double.parseDouble(req.getParameter("totalPrice"));	
	    	String subject="Total Price "+totalprice;
	    	
	        service.sendEmail(emailID, "order get places", subject);
	        return new ModelAndView("Success", "message", "Email sent successfully to " + emailID);
		    }
	
	}
