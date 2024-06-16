package com.babu.fooddelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.entity.OrderItem;
import com.babu.fooddelivery.repository.CartRepo;

@Service
public class CartService {
	
	@Autowired
	CartRepo cartrepo;
	
	public String addtocart(OrderItem cart) {
		cartrepo.save(cart);
		return cart.getOrderItemId() + "Item Added To Cart SuccessFull";
	}
}
