package com.babu.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.entity.Orders;
import com.babu.fooddelivery.repository.OrderRepo;


@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderrepo;
	
	public String placeOrder(Orders order) {
		orderrepo.save(order);
		return order.getOrderId() + "Order Placed SuccessFull";
	}
	
	public List<Orders> GetOrderHistory(Integer id){
		List<Orders> order = orderrepo.findByUserId(id);
		return order;
	}
	
	public List<Orders> GetResOrders(Integer id){
		List<Orders> order = orderrepo.findByResId(id);
		return order;
	}
}
