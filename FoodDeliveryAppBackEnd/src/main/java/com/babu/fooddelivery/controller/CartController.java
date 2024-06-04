package com.babu.fooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.Services.CartService;
import com.babu.fooddelivery.dto.OrderItems;



@RestController
@RequestMapping(value = "/api/cart")
public class CartController {
	
	@Autowired
	CartService cartser;
	
	@PostMapping("/additems" )
	public ResponseEntity<String> AddCart(@RequestBody OrderItems item) {
		if(cartser.AddItemsCart(item)!= null) {
			String Message = "Item Added to Cart Successfull";
			System.out.println(item);
			return ResponseEntity.ok(Message);
		}		
		return ResponseEntity.ok("Item Added to Cart Failed");
	}
	
}
