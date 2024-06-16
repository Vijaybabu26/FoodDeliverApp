package com.babu.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.Orders;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders, Integer>{
//	List<Orders> findbyuserId(Integer userId);
}
