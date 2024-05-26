package com.babu.fooddelivery.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.dto.Restaurant;
import com.babu.fooddelivery.repo.RestaurantRepo;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	
	@Autowired
	RestaurantRepo restrepo;
	@PostMapping("/RegisterRestaurant")
	public ResponseEntity<Restaurant> RegisterRestaurant(@RequestBody Restaurant res){
		return new ResponseEntity<>(restrepo.save(res),HttpStatus.CREATED);
	}
	
	@GetMapping("/RestaurantList")
	 public ResponseEntity<List<Restaurant>> GetRestaurantList(){
		 return new ResponseEntity<>(restrepo.findAll(),HttpStatus.OK);
	 }
	
	@GetMapping("/RestaurantDetails/{RestaurantId}")
	public ResponseEntity<Restaurant> GetRestaurantById(@PathVariable long RestaurantId){
		Optional<Restaurant> rest = restrepo.findById(RestaurantId);
		if(rest.isPresent()) {
			return new ResponseEntity<Restaurant>(rest.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
