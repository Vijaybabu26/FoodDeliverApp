package com.babu.fooddelivery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.OrderItemsDTO;
import com.babu.fooddelivery.repository.CartRepo;
@Service
public class CartService {
	
	@Autowired
	CartRepo cart;
	
	public OrderItemsDTO AddItemsCart(OrderItemsDTO order) {
		return cart.save(order);
	}
}
