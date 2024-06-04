package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.OrderItems;


public interface CartRepo extends JpaRepository<OrderItems, Integer>{

}
