package com.babu.fooddelivery.controller;

import java.util.List;
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

import com.babu.fooddelivery.entity.Orders;
import com.babu.fooddelivery.entity.User;
import com.babu.fooddelivery.repository.OrderRepo;
import com.babu.fooddelivery.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService orderser;
	
	@Autowired
	OrderRepo orderrepo;
	
	@PostMapping("/order")
	public ResponseEntity<String> placeorder(@RequestBody Orders order){
		if(orderser.placeOrder(order)!=null) {
			String message = "Order Placed Succesfull";
			System.out.println(order);
			return ResponseEntity.status(HttpStatus.CREATED).body(order.getOrderId() + " " + message);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order Placing Failed due to invalid data.");
	}
	
	@GetMapping("/orderdetails/{orderId}")
	public ResponseEntity<Orders> getOrderDetails(@PathVariable("orderId") Integer orderId){
		String id = orderId.toString();
		Optional<Orders> order = orderrepo.findById(Integer.parseInt(id));
		if(order.isPresent()) {
			Orders order1 = order.get();
			return new ResponseEntity<>(order1, HttpStatus.OK);
		} else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	


	

	
	@GetMapping("/orderhistory")
	public ResponseEntity<List<Orders>> getOrderHistory(@RequestBody Orders order) {
	    User u = order.getUserId();
	    List<Orders> orderhis = orderser.GetOrderHistory(u.getUserId());
	    if(orderhis.isEmpty()) {
	    	System.out.println("Not Found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(orderhis,HttpStatus.OK);
	}



}
