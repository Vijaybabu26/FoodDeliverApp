package com.babu.fooddelivery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.Services.RestaurantService;
import com.babu.fooddelivery.dto.Restaurant;


@RestController
@RequestMapping(value = "/api/restaurant" ,consumes = "application/json;charset=UTF-8")
public class RestaurantController {
	
	@Autowired
	RestaurantService resser;
	
	@PostMapping("/registerRestaurant" )
	public ResponseEntity<String> RegisterRestaurant(@RequestBody Restaurant res) {
		if(resser.registerRestaurant(res) != null) {
			String Message = "Registration Successfull";
			System.out.println(res);
			return ResponseEntity.ok(Message);
		}		
		return ResponseEntity.ok("Registration Failed");
	}
	
	@GetMapping("/getRestaurantDetails/{ResId}")
	public ResponseEntity<Restaurant> GetRestaurantDetails(@PathVariable Integer ResId){
		Restaurant res = resser.getRestaurantDetails(ResId);
		if(res != null) {
		        return ResponseEntity.ok(res);
		} else {
		        return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/RestaurantList")
	public ResponseEntity<List<Restaurant>> GetRestaurantlist(){
		List<Restaurant> resList = resser.GetRestaurantList();
		if(resList != null) {
			return ResponseEntity.ok(resList);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
