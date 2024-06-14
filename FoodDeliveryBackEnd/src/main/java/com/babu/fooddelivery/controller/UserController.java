package com.babu.fooddelivery.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.dto.UserDTO;
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
	public ResponseEntity<String> registerUser(@RequestBody UserDTO user) {
		String phoneNo = user.getPhoneNo();
	    if (userrepo.findByPhoneNo(phoneNo) != null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
	    }
	    
	    if (userser.registeruser(user) != null) {
	        String message = "Registration Successful";
	        System.out.println(user);
	        return ResponseEntity.ok(user.getUserName() + message);
	    }
	    
	    return ResponseEntity.ok("Registration Failed");
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
		String phoneNo = loginRequest.getPhoneNo();
		
		if(userser.getUserDetails(phoneNo) != null) {
			System.out.println("Login S");
			 return ResponseEntity.ok("Login successful!" + loginRequest.getPhoneNo());
		}
		System.out.println("Login f");
		 return ResponseEntity.ok("Login Failed");
		
	}
	
//	@GetMapping("/login/{phoneNo}")
//	public User getUserDetails(@PathVariable("phoneNo") String phoneNo) {
//		return userser.getUserDetails(phoneNo);
//	}
	
	
//	@GetMapping("/login")
//	public User getUser(@PathVariable String id) {
//		
//	    return userser.getBand(Integer.parseInt(id)).orElseThrow();
//	}
	
//	 @PostMapping("/loginuser")
//	    public ResponseEntity<String> loginUser(@RequestBody User user) {
//	        User u = userdao.getEmployeeById(user.getPhoneNo());
//	        if (u != null) {
//	        	System.out.println(user.getPhoneNo());
//	            return ResponseEntity.ok("User found: " + u.toString());
//	        } else {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//	        }
//	    }
//	@PostMapping("/loginuser")
//    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
//        boolean isAuthenticated = userser.login(loginDTO);
//
//        if (isAuthenticated) {
//            return ResponseEntity.ok("Login Successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
//        }
//    }
//	
//	@PostMapping("/login")
//	public String loginuser(@ModelAttribute UserDTO userdto,Model model) {
//		if(userser.login(userdto)) {
//			return "Login Success";
//		}
//		model.addAttribute("error", "Invalid Username Password");
//		return "logiin";
//	}
	
//	@PostMapping("/login")
//	public ResponseEntity<String> loginUser(@RequestBody String phoneNo) {
//	   
//
//	    if (user != null) {
//	        return ResponseEntity.ok("User found: " + user.toString());
//	    } else {
//	        return ResponseEntity.notFound().build();
//	    }
//	}
}
