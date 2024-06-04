package com.babu.fooddelivery.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.Order;
import com.babu.fooddelivery.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderrepo;
	
	public Order PlaceOrder(Order ordder) {
		return orderrepo.save(ordder);
	}
	
	public List<Order> GetOrderHistory(){
		return orderrepo.findAll();
	}
	
	public String GetOrderStatus(Integer OrderId) {
		Optional<Order> optionalOrder = orderrepo.findById(OrderId);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			return order.getStatus();
		}else {
			return null;
		}
	}
}
