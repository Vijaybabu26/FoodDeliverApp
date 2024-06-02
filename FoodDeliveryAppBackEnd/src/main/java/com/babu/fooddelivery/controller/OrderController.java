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

import com.babu.fooddelivery.Services.OrderService;
import com.babu.fooddelivery.dto.OrderDTO;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

	@Autowired
	OrderService orderser;
	
	@PostMapping("/placeorder" )
	public ResponseEntity<String> PlaceOrder(@RequestBody OrderDTO order) {
		if(orderser.PlaceOrder(order)!= null) {
			String Message = "Order Placed Successfull";
			System.out.println(order);
			return ResponseEntity.ok(Message);
		}		
		return ResponseEntity.ok("Order Placed Failed");
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<OrderDTO>> GetOrderHistory(){
		List<OrderDTO> orderList = orderser.GetOrderHistory();
		if(orderList != null) {
			return ResponseEntity.ok(orderList);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/OrderStatus")
	public ResponseEntity<String> GetOrderStatus(@PathVariable Integer OrderId){
		String status = orderser.GetOrderStatus(OrderId);
		  if (status != null) {
	            return ResponseEntity.ok(status);
	        } else {
	            return ResponseEntity.ok("Not Found");
	        }
	}
}
