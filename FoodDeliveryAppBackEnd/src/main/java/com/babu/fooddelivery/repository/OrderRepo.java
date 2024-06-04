package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{
	
}
