package com.artapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artapp.model.Customer;
import com.artapp.repository.CustomerRepository;

@Service
public class CustomerServices {

	@Autowired
	private CustomerRepository repo;
	
	public String saveCustomer(Customer customer) {
		repo.save(customer);
		return "Customer Saved";
	}
	
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}
	
	public Customer getCustomerById(String email) {
		return repo.findById(email).orElse(null); // select * from Pet where petId=?;
	}
	
	public String deleteCustomerById(String email) {
		repo.deleteById(email);
		return "delete";
	}
}
