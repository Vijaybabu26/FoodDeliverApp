package com.babu.fooddelivery.controller;




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


import com.babu.fooddelivery.entity.User;
import com.babu.fooddelivery.repository.UserRepo;
import com.babu.fooddelivery.service.UserService;







@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userser;
	
	@Autowired
	UserRepo userrepo;
	
	@PostMapping("/registeruser")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
	    String phoneNo = user.getPhoneNo();
	    Optional<User> existingUser = userrepo.findByPhoneNo(phoneNo);
	    if (existingUser.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("User with phone number " + phoneNo + " already exists.");
	    } else if (userser.registeruser(user) != null) {
	        String message = "Registration Successful";
	        System.out.println(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body(user.getUserName() + " " + message);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Failed due to invalid data.");
	}

	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
		String phoneNo = loginRequest.getPhoneNo();
		String password = loginRequest.getPassword();
		Optional<User> user = userser.getUserDetails(phoneNo);
		User user1 = user.get();
		String passworde = user1.getPassword();
		if(user.isPresent()) {
			 if(password.equals(passworde)) {
				 System.out.println("Login S");
				 
				 UUID uuid = UUID.randomUUID();
				 String Token = (uuid.toString()).toUpperCase();
				return ResponseEntity.ok("Login successful!" +" " + loginRequest.getPhoneNo()+" " + user1.getEmailId() +" "+Token);
			 
			 }
			}
		System.out.println("Login f");
		 return ResponseEntity.ok("Login Failed");
	}
	
	@GetMapping("/getuserdetails/{phoneNo}")
	public ResponseEntity<User> retrieveUserDetails(@PathVariable("phoneNo") String phoneNo) {
		String phno = phoneNo.toString();
	    Optional<User> user = userser.getUserDetails(phno);
	    System.out.println(phoneNo);
	    if (user.isPresent()) {
	        User u = user.get();
	        return new ResponseEntity<>(u, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	
	
}
