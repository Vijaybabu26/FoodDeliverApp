package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.babu.fooddelivery.dto.RestaurantDTO;

public interface RestaurantRepo extends JpaRepository<RestaurantDTO, Integer>{
	
	@Query("SELECT r FROM RestaurantDTO r WHERE r.ResId = ?1")
	RestaurantDTO FindResDetailsById(Integer ResId);
	

}
