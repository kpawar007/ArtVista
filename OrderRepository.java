package com.artapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artapp.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
