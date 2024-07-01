package com.babu.fooddelivery.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.entity.Restaurant;

import com.babu.fooddelivery.repository.RestaurantRepo;
import com.babu.fooddelivery.service.RestaurantService;

@RestController
@CrossOrigin
@RequestMapping("/api/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService resser;
	
	@Autowired
	RestaurantRepo resrepo;
	
	@PostMapping("/registerrestaurant")
	public ResponseEntity<String> registerUser(@RequestBody Restaurant res) {
	    String resPhoneNo = res.getResPhoneNo();
	    Optional<Restaurant> existingRestaurant = resrepo.findByresPhoneNo(resPhoneNo);
	    if (existingRestaurant.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Restaurant with phone number " + resPhoneNo + " already exists.");
	    } else if (resser.RegisterRestaurant(res) != null) {
	        String message = "Registration Successful";
	        System.out.println(res);
	        return ResponseEntity.status(HttpStatus.CREATED).body(res.getResName() + " " + message);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Failed due to invalid data.");
	}
	

	@PostMapping("/updaterestaurant")
	public ResponseEntity<String> updateRestaurant(@RequestBody Restaurant res){
		Optional<Restaurant> existingRestaurant = resrepo.findById(res.getResId());
		if(existingRestaurant.isPresent()) {
			Restaurant ures = existingRestaurant.get();
			ures.setResId(ures.getResId());
			ures.setResName(res.getResName());
			ures.setResPhoneNo(res.getResPhoneNo());
			ures.setResAddress(res.getResAddress());
			ures.setResAvgRating(res.getResAvgRating());
			ures.setResDelievryFee(res.getResDelievryFee());
			ures.setResDescription(res.getResDescription());
			ures.setResImage(res.getResImage());
			ures.setResOperationHours(res.getResOperationHours());
			ures.setResPassword(res.getResPassword());
			resrepo.save(ures);
			String message = "Restaurant Details Updated Successfully";
	        System.out.println(ures);
	        return ResponseEntity.status(HttpStatus.OK).body(ures.getResName() + " " + message);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant Details Not Updated");
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginRestaurant(@RequestBody Restaurant loginres){
		String resPhoneNo = loginres.getResPhoneNo();
		String resPassword = loginres.getResPassword();
		Optional<Restaurant> res = resser.GetResDetailsByPhNo(resPhoneNo);
		Restaurant restaurant = res.get();
		String respassworde = restaurant.getResPassword();
		if(res.isPresent()) {
			if(resPassword.equals(respassworde)) {
				System.out.println("Login S");
				 
				 UUID uuid = UUID.randomUUID();
				 String Token = (uuid.toString()).toUpperCase();
				return ResponseEntity.ok("Login successful!" +" " + loginres.getResPhoneNo()+" " + restaurant.getResName() +" "+Token);
			 
			}
		}
		System.out.println("Login f");
		 return ResponseEntity.ok("Login Failed");
	}
	
	@GetMapping("/restaurantlist")
	public ResponseEntity<List<Restaurant>> GetAllRestaurant(){
		List<Restaurant> restaurants = resser.GetAllRestaurants();
		if (restaurants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
	}
	
	@GetMapping("/restaurantdetails/{phoneNo}")
	public ResponseEntity<Restaurant> GetRestaurantsByPhno(@PathVariable("phoneNo") String phoneNo){
		String phno = phoneNo.toString();
		Optional<Restaurant> restaurant = resser.GetResDetailsByPhNo(phno);
		if(restaurant.isPresent()) {
			Restaurant res = restaurant.get();
			return new ResponseEntity<>(res, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
