package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.OrderDTO;

public interface OrderRepo extends JpaRepository<OrderDTO, Integer>{
	
}
