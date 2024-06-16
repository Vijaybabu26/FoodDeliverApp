package com.babu.fooddelivery.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.Restaurant;


@Repository
@EnableJpaRepositories
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{
	
	public Optional<Restaurant> findByresPhoneNo(String resPhoneNo);
	
}
