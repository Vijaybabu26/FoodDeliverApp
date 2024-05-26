package com.babu.fooddelivery.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Order_Details")
public class OrderDetails {

@Id
@Column(name ="Order_Id")
private String OrderId;
@ManyToOne
@JoinColumn(name="User_Id", referencedColumnName ="User_Id")
private long UserId;

@ManyToOne
@JoinColumn(name="Restaurant_Id", referencedColumnName ="Restaurant_Id")
private long RestaurantId;

@Column(name="Order_Date")
private Date OrderDate;

@Column(name="Total_Amount")
private double TotalAmount;

@Column(name="Delivery_Address")
private String DeliveryAddress;

@Column(name = "Delivery_Time")
private Date DeliveryTime;

@Column(name = "Order_Status")
private String OrderStatus;

public String getOrderId() {
	return OrderId;
}

public void setOrderId(String orderId) {
	OrderId = orderId;
}

public long getUserId() {
	return UserId;
}

public void setUserId(long userId) {
	UserId = userId;
}

public long getRestaurantId() {
	return RestaurantId;
}

public void setRestaurantId(long restaurantId) {
	RestaurantId = restaurantId;
}

public Date getOrderDate() {
	return OrderDate;
}

public void setOrderDate(Date orderDate) {
	OrderDate = orderDate;
}

public double getTotalAmount() {
	return TotalAmount;
}

public void setTotalAmount(double totalAmount) {
	TotalAmount = totalAmount;
}

public String getDeliveryAddress() {
	return DeliveryAddress;
}

public void setDeliveryAddress(String deliveryAddress) {
	DeliveryAddress = deliveryAddress;
}

public Date getDeliveryTime() {
	return DeliveryTime;
}

public void setDeliveryTime(Date deliveryTime) {
	DeliveryTime = deliveryTime;
}

public String getOrderStatus() {
	return OrderStatus;
}

public void setOrderStatus(String orderStatus) {
	OrderStatus = orderStatus;
}

public OrderDetails(String orderId, long userId, long restaurantId, Date orderDate, double totalAmount,
		String deliveryAddress, Date deliveryTime, String orderStatus) {
	super();
	this.OrderId = orderId;
	this.UserId = userId;
	this.RestaurantId = restaurantId;
	this.OrderDate = orderDate;
	this.TotalAmount = totalAmount;
	this.DeliveryAddress = deliveryAddress;
	this.DeliveryTime = deliveryTime;
	this.OrderStatus = orderStatus;
}

public OrderDetails() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "OrderDetails [OrderId=" + OrderId + ", UserId=" + UserId + ", RestaurantId=" + RestaurantId + ", OrderDate="
			+ OrderDate + ", TotalAmount=" + TotalAmount + ", DeliveryAddress=" + DeliveryAddress + ", DeliveryTime="
			+ DeliveryTime + ", OrderStatus=" + OrderStatus + "]";
}



}
