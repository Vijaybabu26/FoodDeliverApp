package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.OrderItem;



@Repository
@EnableJpaRepositories
public interface CartRepo extends JpaRepository<OrderItem, Integer> {

}
