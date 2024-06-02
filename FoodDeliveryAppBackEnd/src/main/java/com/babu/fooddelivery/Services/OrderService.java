package com.babu.fooddelivery.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.OrderDTO;
import com.babu.fooddelivery.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderrepo;
	
	public OrderDTO PlaceOrder(OrderDTO order) {
		return orderrepo.save(order);
	}
	
	public List<OrderDTO> GetOrderHistory(){
		return orderrepo.findAll();
	}
	
	public String GetOrderStatus(Integer OrderId) {
		Optional<OrderDTO> optionalOrder = orderrepo.findById(OrderId);
		if (optionalOrder.isPresent()) {
			OrderDTO order = optionalOrder.get();
			return order.getStatus();
		}else {
			return null;
		}
	}
}
