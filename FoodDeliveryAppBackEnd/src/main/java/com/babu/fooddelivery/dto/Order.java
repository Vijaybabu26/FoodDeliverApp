package com.babu.fooddelivery.dto;

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
@Table(name ="Orders")
public class Order{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="OrderId")
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name= "UserId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name= "ResId")
	private Restaurant restaurant;
	
	@Column(name ="OrderDate")
	private LocalDateTime urderDate;
	
	@Column(name ="Amount")
	private double amount;
	
	@Column(name = "DeliveryAddress")
	private String deliveryAddress;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "DeliveryTime")
	private LocalDateTime deliveryTime;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", restaurant=" + restaurant + ", urderDate="
				+ urderDate + ", amount=" + amount + ", deliveryAddress=" + deliveryAddress + ", status=" + status
				+ ", deliveryTime=" + deliveryTime + "]";
	}

	public Order(Integer orderId, User user, Restaurant restaurant, LocalDateTime urderDate, double amount,
			String deliveryAddress, String status, LocalDateTime deliveryTime) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.restaurant = restaurant;
		this.urderDate = urderDate;
		this.amount = amount;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.deliveryTime = deliveryTime;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDateTime getUrderDate() {
		return urderDate;
	}

	public void setUrderDate(LocalDateTime urderDate) {
		this.urderDate = urderDate;
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
