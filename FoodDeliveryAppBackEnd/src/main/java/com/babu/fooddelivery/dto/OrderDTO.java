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
public class OrderDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="OrderId")
	private Integer OrderId;
	
	@ManyToOne
	@JoinColumn(name= "UserId")
	private UserDTO User;
	
	@ManyToOne
	@JoinColumn(name= "ResId")
	private RestaurantDTO Restaurant;
	
	@Column(name ="OrderDate")
	private LocalDateTime OrderDate;
	
	@Column(name ="Amount")
	private double Amount;
	
	@Column(name = "DeliveryAddress")
	private String DeliveryAddress;
	
	@Column(name = "Status")
	private String Status;
	
	@Column(name = "DeliveryTime")
	private LocalDateTime DeliveryTime;

	
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(Integer orderId, UserDTO user, RestaurantDTO restaurant, LocalDateTime orderDate, double amount,
			String deliveryAddress, String status, LocalDateTime deliveryTime) {
		super();
		OrderId = orderId;
		User = user;
		Restaurant = restaurant;
		OrderDate = orderDate;
		Amount = amount;
		DeliveryAddress = deliveryAddress;
		Status = status;
		DeliveryTime = deliveryTime;
	}

	@Override
	public String toString() {
		return "OrderDTO [OrderId=" + OrderId + ", User=" + User + ", Restaurant=" + Restaurant + ", OrderDate="
				+ OrderDate + ", Amount=" + Amount + ", DeliveryAddress=" + DeliveryAddress + ", Status=" + Status
				+ ", DeliveryTime=" + DeliveryTime + "]";
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public UserDTO getUser() {
		return User;
	}

	public void setUser(UserDTO user) {
		User = user;
	}

	public RestaurantDTO getRestaurant() {
		return Restaurant;
	}

	public void setRestaurant(RestaurantDTO restaurant) {
		Restaurant = restaurant;
	}

	public LocalDateTime getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		OrderDate = orderDate;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getDeliveryAddress() {
		return DeliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public LocalDateTime getDeliveryTime() {
		return DeliveryTime;
	}

	public void setDeliveryTime(LocalDateTime deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	
	
}
