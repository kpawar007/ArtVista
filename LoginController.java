package com.artapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.artapp.model.Customer;
import com.artapp.model.Login;
import com.artapp.repository.CustomerRepository;
import com.artapp.repository.LoginRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private CustomerRepository crepo;

    @Autowired
    private LoginRepository arepo;

    @GetMapping("/login")  // ✅ SAME URL for GET
    public String ShowLogin() {
        return "login";
    }

    @PostMapping("/login") // ✅ SAME URL for POST
    public String saveLogin(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Customer cust = crepo.findByEmailAndPassword(email, password);
        Login alogin = arepo.findByEmailIdAndPassword(email, password);

        if (cust != null) {
        	session.setAttribute("customerEmailID", email);
            return "index";
        } else if (alogin != null) {
        	session.setAttribute("adminEmailID", email);
            return "index";
        } else {
            return "fail";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "index";
    }
}
