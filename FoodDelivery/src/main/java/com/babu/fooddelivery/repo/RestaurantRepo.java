package com.babu.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant,Long>{

}
