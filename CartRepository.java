package com.artapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.artapp.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	List<Cart> findByEmail(String email);
	
	@Query("SELECT SUM(c.totalPrice) FROM Cart c WHERE c.email = :email")
	Double getTotalPriceSumByEmail(@Param("email") String email);
	
	
}
