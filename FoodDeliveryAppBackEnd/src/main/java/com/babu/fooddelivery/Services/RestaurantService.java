package com.babu.fooddelivery.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.Restaurant;

import com.babu.fooddelivery.repository.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo resrepo;
	
	public Restaurant registerRestaurant(Restaurant res) {
		return resrepo.save(res);
	}
	
	public Restaurant getRestaurantDetails(Integer resId) {
		return resrepo.FindResDetailsById(resId);
	}
	
	public List<Restaurant> GetRestaurantList(){
		return resrepo.findAll();
	}
	
}
