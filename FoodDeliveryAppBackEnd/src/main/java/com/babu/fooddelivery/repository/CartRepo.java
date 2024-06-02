package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.OrderItemsDTO;

public interface CartRepo extends JpaRepository<OrderItemsDTO, Integer>{

}
