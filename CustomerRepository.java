package com.artapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	public Customer findByEmail(String email);
	
	Customer findByEmailAndPassword(String email, String password);
	
}
