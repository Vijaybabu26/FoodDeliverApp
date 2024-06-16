package com.babu.fooddelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.entity.Restaurant;
import com.babu.fooddelivery.repository.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo resrepo;
	
	public String RegisterRestaurant(Restaurant restaurant) {
		resrepo.save(restaurant);
		return restaurant.getResName();
	}
	
	public List<Restaurant> GetAllRestaurants(){
		List<Restaurant> restaurants =  resrepo.findAll();
		return restaurants;
	}
	
	public Optional<Restaurant> GetResDetailsByPhNo(String resPhoneNo){
		Optional<Restaurant> res = resrepo.findByresPhoneNo(resPhoneNo);
		return res;
	}
}
