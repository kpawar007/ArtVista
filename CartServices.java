package com.artapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artapp.model.Cart;
import com.artapp.repository.CartRepository;

@Service
public class CartServices {
	
	@Autowired
	private CartRepository repo;
	
	public String addCart(Cart cart) {
		repo.save(cart);
		return "Cart Added";
	}
	
	public String deleteCartById(int id) { //service
        repo.deleteById(id);  // This deletes by cartId
        return "delete";
    }
	
}
