package com.babu.fooddelivery.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="orderId")
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name= "userId")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name= "resId")
	private Restaurant restaurant;
	
	@Column(name ="orderDate")
	private LocalDateTime orderDate;
	
	@Column(name ="amount")
	private double amount;
	
	@Column(name = "deliveryAddress")
	private String deliveryAddress;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "deliveryTime")
	private LocalDateTime deliveryTime;

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", restaurant=" + restaurant + ", orderDate="
				+ orderDate + ", amount=" + amount + ", deliveryAddress=" + deliveryAddress + ", status=" + status
				+ ", deliveryTime=" + deliveryTime + "]";
	}

	public Orders(Integer orderId, User userId, Restaurant restaurant, LocalDateTime orderDate, double amount,
			String deliveryAddress, String status, LocalDateTime deliveryTime) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurant = restaurant;
		this.orderDate = orderDate;
		this.amount = amount;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.deliveryTime = deliveryTime;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	
}
