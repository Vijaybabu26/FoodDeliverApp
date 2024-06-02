package com.babu.fooddelivery.controller;





import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.Services.UserService;
import com.babu.fooddelivery.dto.UserDTO;


@RestController
@RequestMapping(value = "/api/user" ,consumes = "application/json;charset=UTF-8")
public class UserController {
	
	@Autowired
	UserService userser;
	
	

	
	@PostMapping("/registeruser" )
	public ResponseEntity<String> RegisterUser(@RequestBody UserDTO user) {
		if(userser.registerUser(user) != null) {
			String Message = "Registration Successfull";
			System.out.println(user);
			return ResponseEntity.ok(Message);
		}		
		return ResponseEntity.ok("Registration Failed");
	}
	
	@PostMapping("/loginuser/{PhoneNo}")
	public ResponseEntity<String> LoginUser(@PathVariable String PhoneNo){
		
		if(userser.getUserWithAccounts(PhoneNo) != null) {
			UUID uuid = UUID.randomUUID();
	        String Token = "TOKEN" + uuid.toString() + "FOODDELIVERY"; 
			return ResponseEntity.ok("Login Success" + Token.toUpperCase());
		}
		return ResponseEntity.ok("Login Failed");
	}
	
	@GetMapping("/user/{PhoneNo}")
	public ResponseEntity<UserDTO> getUserDetails(@PathVariable String PhoneNo) {
	    UserDTO user = userser.getUserWithAccounts(PhoneNo);
	    if (user != null) {
	        return ResponseEntity.ok(user);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
