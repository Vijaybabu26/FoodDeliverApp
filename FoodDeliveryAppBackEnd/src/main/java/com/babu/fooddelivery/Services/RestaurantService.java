package com.babu.fooddelivery.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.RestaurantDTO;
import com.babu.fooddelivery.repository.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo resrepo;
	
	public RestaurantDTO registerRestaurant(RestaurantDTO res) {
		return resrepo.save(res);
	}
	
	public RestaurantDTO GetRestaurantDetails(Integer ResId) {
		return resrepo.FindResDetailsById(ResId);
	}
	
	public List<RestaurantDTO> GetRestaurantList(){
		return resrepo.findAll();
	}
	
}
