package com.babu.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.OrderItems;


public interface OrderItemRepo extends JpaRepository<OrderItems,Long>{

}
