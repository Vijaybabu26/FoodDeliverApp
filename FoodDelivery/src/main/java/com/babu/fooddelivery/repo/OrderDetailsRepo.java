package com.babu.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.OrderDetails;


public interface OrderDetailsRepo extends JpaRepository<OrderDetails,String>{

}
