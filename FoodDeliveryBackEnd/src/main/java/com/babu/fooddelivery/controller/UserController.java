package com.babu.fooddelivery.controller;




import java.util.Optional;

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
	

	
	@PostMapping("/updateuser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
	    Optional<User> existingUser = userrepo.findById(user.getUserId());
	    
	    if (existingUser.isPresent()) {
	        User uuser = existingUser.get();
	        uuser.setUserId(uuser.getUserId());
	        uuser.setUserName(user.getUserName());
	        uuser.setEmailId(user.getEmailId());
	        uuser.setPassword(user.getPassword());
	        uuser.setPhoneNo(user.getPhoneNo());
	        uuser.setAddress(user.getAddress());
	        userrepo.save(uuser);
	        
	        String message = "User Details Updated Successfully";
	        System.out.println(uuser);
	        return ResponseEntity.status(HttpStatus.OK).body(user.getUserName() + " " + message);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Details Not Updated");
	    }
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User loginRequest) {
	    String phoneNo = loginRequest.getPhoneNo();
	    String password = loginRequest.getPassword();
	    Optional<User> user = userser.getUserDetails(phoneNo);

	    if (user.isPresent()) {
	        User user1 = user.get();
	        String storedPassword = user1.getPassword();

	        if (password.equals(storedPassword)) {
	            System.out.println("Login Successful");
	            // You can generate and return an authentication token here if needed
	            return ResponseEntity.ok(user1);
	        } else {
	            System.out.println("Incorrect password");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    } else {
	        System.out.println("User not found");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
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
