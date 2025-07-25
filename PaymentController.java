package com.artapp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PaymentController {
	
	@Value("${razorpay.key}")
    private String razorpayKey;

    @Value("${razorpay.secret}")
    private String razorpaySecret;

    @GetMapping("/pay")
    public ModelAndView paymentPage(HttpServletRequest req) throws RazorpayException {
        RazorpayClient client = new RazorpayClient(razorpayKey, razorpaySecret);
        System.out.println(req.getParameter("totalPrice"));
        double amount=Double.parseDouble(req.getParameter("totalPrice"));
        System.out.println(amount);
        String emailId=req.getParameter("emailId");
        req.getParameter(razorpayKey)  ;
        JSONObject options = new JSONObject();
        options.put("amount", amount*100); // Amount in paise (Rs 500)
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");

        Order order = client.orders.create(options);

        ModelAndView mv = new ModelAndView("PaymentSuccess");
        mv.addObject("orderId", order.get("id"));
        mv.addObject("amount", order.get("amount"));
        mv.addObject("razorpayKey", razorpayKey);
        mv.addObject("currency", order.get("currency"));
        return mv;
    }

    @PostMapping("/paymentSuccess")
    public String paymentSuccess(HttpServletRequest request) {
        // You can verify signature and save details
        String paymentId = request.getParameter("razorpay_payment_id");
        String orderId = request.getParameter("razorpay_order_id");
        String signature = request.getParameter("razorpay_signature");

        // Store in DB, verify, etc.

        return "Success"; // JSP page
	
    }
}
