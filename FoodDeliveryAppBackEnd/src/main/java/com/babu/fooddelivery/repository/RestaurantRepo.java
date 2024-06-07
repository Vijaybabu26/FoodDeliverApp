package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.babu.fooddelivery.dto.Restaurant;


public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{
	
	@Query("SELECT r FROM Restaurant r WHERE r.resId = ?1")
	Restaurant FindResDetailsById(Integer resId);
	@Query("SELECT r FROM Restaurant r WHERE r.resName = ?1")
	Restaurant findByName(String resName);
}
