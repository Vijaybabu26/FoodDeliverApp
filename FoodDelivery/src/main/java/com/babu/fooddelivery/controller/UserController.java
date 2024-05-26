package com.babu.fooddelivery.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.dto.OrderDetails;
import com.babu.fooddelivery.dto.OrderItems;
import com.babu.fooddelivery.dto.User;
import com.babu.fooddelivery.repo.OrderDetailsRepo;
import com.babu.fooddelivery.repo.OrderItemRepo;
import com.babu.fooddelivery.repo.UserRepo;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserRepo userrepo;
	
//	@PostMapping("/register")
//	public ResponseEntity<User> RegisterUser(@RequestBody User user) {
//		
//		return new ResponseEntity<>(userrepo.save(user),HttpStatus.CREATED);
//		
//	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody User user) {
		
	    User savedUser = userrepo.save(user);
	    return ResponseEntity.status(HttpStatus.CREATED)
	        .body("Registration Successful for user: " + savedUser.getUserName());
	    
	}

	
//	@GetMapping("/login/{UserId}")
//	public ResponseEntity<User> Login(@PathVariable long UserId){
//		Optional<User> user = userrepo.findById(UserId);
//		if(user.isPresent()) {
//			UUID Uui = UUID.randomUUID();
//			String Token = "TOKEN" + Uui.toString() + "FOODDELIVERY"; 
//			return new ResponseEntity<User>(user.get(),HttpStatus.OK);
//			
//		}else {
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/login/{UserId}")
	public ResponseEntity<String> login(@PathVariable long UserId) {
	    Optional<User> user = userrepo.findById(UserId);
	    if (user.isPresent()) {
	        UUID uuid = UUID.randomUUID();
	        String token = "TOKEN" + uuid.toString() + "FOODDELIVERY";
	        return ResponseEntity.ok("User found. Token: " + token);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
	@Autowired
	OrderItemRepo items;
	
	@PostMapping("/AddToCart")
	public ResponseEntity<String> AddToCart(@RequestBody OrderItems cart){
		OrderItems orderitems = items.save(cart);
		return ResponseEntity.status(HttpStatus.CREATED)
			        .body("Order Added to cart SuccessFull" + orderitems.getOrderItemId());
	}
	
	@Autowired
	OrderDetailsRepo placed;
	public ResponseEntity<String> PlaceOrder(@RequestBody OrderDetails Order){
		OrderDetails orders = placed.save(Order);
		return ResponseEntity.status(HttpStatus.CREATED)
		        .body("Order Placed Successfull" + orders.getOrderId());
	}
//	
//	 @GetMapping("/OrderHistory/{UserId}")
//	    public ResponseEntity<List<OrderDetails>> getOrderHistory(@PathVariable long UserId) {
//	        List<OrderDetails> orderHistory = placed.findById(UserId);
//	        
//	        if (orderHistory.isEmpty()) {
//	            return ResponseEntity.notFound().build();
//	        }
//	        
//	        return ResponseEntity.ok(orderHistory);
//	    }
	
	@GetMapping("/OrderHistory/{UserId}")
	 public ResponseEntity<List<OrderDetails>> GetRestaurantList(@PathVariable long UserId){
		 return new ResponseEntity<>(placed.findAll(),HttpStatus.OK);
	 }
		
	@GetMapping("/Profile/{UserId}")
	public ResponseEntity<User> GetProfilebyId(@PathVariable long UserId){
		Optional<User> user = userrepo.findById(UserId);
		if(user.isPresent()) {
			return new ResponseEntity<User>(user.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}	
}
