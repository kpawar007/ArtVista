package com.artapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.artapp.model.Orders;
import com.artapp.repository.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository repo;
	 @Autowired
	    private JavaMailSender mailSender;
	
	public Orders saveOrder(Orders order)
	{
		Orders order1=repo.save(order);
		return order1;
	}
	

	    public void sendEmail(String toEmail, String subject, String body) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("pawarkanhaiya30@gmail.com");
	        message.setTo(toEmail);
	        message.setSubject(subject);
	        message.setText(body);

	        mailSender.send(message);
	        System.out.println("Mail sent successfully");
	    }
	
}
