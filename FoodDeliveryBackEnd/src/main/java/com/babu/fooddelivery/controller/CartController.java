package com.babu.fooddelivery.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.entity.Menu;
import com.babu.fooddelivery.entity.OrderItem;
import com.babu.fooddelivery.repository.CartRepo;
import com.babu.fooddelivery.repository.MenuRepo;
import com.babu.fooddelivery.service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class CartController {
	
	
	@Autowired
	CartService cartser;
	
	@Autowired
	MenuRepo menurepo;
	
	@Autowired
	CartRepo cartrepo;
	
	@PostMapping("/addtocart")
	public ResponseEntity<String> addtocart(@RequestBody OrderItem cart){
		Menu menu = cart.getItemId();
		String itemName = menu.getItemName();
		Optional<Menu> existingitem = menurepo.findByItemName(itemName);
		if(existingitem.isPresent()) {
			if(cartser.addtocart(cart) != null) {
				String message = "item Added To Cart Succesfull";
				System.out.println(existingitem);
				return ResponseEntity.status(HttpStatus.CREATED).body(cart.getItemId() + " " + message);
			}
		}
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item Adding Failed due to invalid data.");
	}
	
	@PostMapping("/removefromcart/{orderItemId}")
	public ResponseEntity<OrderItem> deletefromcart(@PathVariable("orderItemId") String orderItemId){
		String id = orderItemId.toString();
		Optional<OrderItem> item = cartrepo.findById(Integer.parseInt(id));
		if(item.isPresent()) {
			OrderItem item1 = item.get();
			Integer DeleteId = item1.getOrderItemId();
			cartrepo.deleteById(DeleteId);
			return new ResponseEntity<>(item1,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
