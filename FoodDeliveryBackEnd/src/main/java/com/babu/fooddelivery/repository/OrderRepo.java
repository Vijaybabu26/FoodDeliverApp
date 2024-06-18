package com.babu.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.Orders;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders, Integer> {
	
	@Query("SELECT o FROM Orders o WHERE o.userId.userId = :userId")
	List<Orders> findByUserId(@Param("userId") Integer userId);

}

