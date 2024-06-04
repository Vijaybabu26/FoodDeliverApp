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
import com.babu.fooddelivery.dto.User;



@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	UserService userser;
	
	

	
	@PostMapping("/registeruser" )
	public ResponseEntity<String> RegisterUser(@RequestBody User user) {
		if(userser.registerUser(user) != null) {
			String Message = "Registration Successfull";
			System.out.println(user);
			return ResponseEntity.ok(Message);
		}		
		return ResponseEntity.ok("Registration Failed");
	}
	
	
	
	@PostMapping("/loginuser/{PhoneNo}")
    public ResponseEntity<String> loginUser(@PathVariable String phoneNo) {
        User user = userser.getUserWithAccounts(phoneNo);
        if (user != null) {
            UUID uuid = UUID.randomUUID();
            String token = "TOKEN" + uuid.toString() + "FOODDELIVERY";
            return ResponseEntity.ok("Login Success. Token: " + token.toUpperCase());
        }
        return ResponseEntity.ok("Login Failed");
    }

	
	@GetMapping("/user/{PhoneNo}")
	public ResponseEntity<User> getUserDetails(@PathVariable String PhoneNo) {
	    User user = userser.getUserWithAccounts(PhoneNo);
	    if (user != null) {
	        return ResponseEntity.ok(user);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
