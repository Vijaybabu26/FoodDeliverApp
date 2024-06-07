package com.babu.fooddelivery.controller;





import java.util.UUID;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.Services.UserService;
import com.babu.fooddelivery.dto.User;



@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	UserService userser;
	
	

	Transaction transaction = null;
	
	@PostMapping("/registeruser")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		String Phno = user.getPhoneNo();
	    if (userser.getUserWithAccounts(Phno)) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
	    }
	    
	    if (userser.registerUser(user) != null) {
	        String message = "Registration Successful";
	        System.out.println(user);
	        return ResponseEntity.ok(message);
	    }
	    
	    return ResponseEntity.ok("Registration Failed");
	}

	
	
	
	@PostMapping("/loginuser/{phoneNo}")
	public ResponseEntity<String> loginUser(@PathVariable String phoneNo, @RequestBody User loginUser) {
		String Phno = loginUser.getPhoneNo();
	   
	    if (userser.getUserWithAccounts(Phno) && loginUser.getPassword().equals(loginUser.getPassword())) {
	        UUID uuid = UUID.randomUUID();
	        String token = "TOKEN" + uuid.toString() + "FOODDELIVERY";
	        return ResponseEntity.ok("Login Success. Token: " + token.toUpperCase());
	    }
	    return ResponseEntity.ok("Login Failed");
	}


	
	@GetMapping("/user/{PhoneNo}")
	public ResponseEntity<User> getUserDetails(@PathVariable String phoneNo,@RequestBody User loginUser) {
        try {
        
            if (userser.getUserWithAccounts(phoneNo)) {
                return ResponseEntity.ok(loginUser);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
}
