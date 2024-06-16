package com.babu.fooddelivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_Item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="orderItemId")
	private Integer orderItemId;
	
	@ManyToOne
	@JoinColumn(name= "orderId")
	private Orders orderId;
	
	@ManyToOne
	@JoinColumn(name= "itemId")
	private Menu itemId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "specialInstructions")
	private String specialInstructions;

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemId=" + itemId + ", quantity="
				+ quantity + ", price=" + price + ", specialInstructions=" + specialInstructions + "]";
	}

	public OrderItem(Integer orderItemId, Orders orderId, Menu itemId, Integer quantity, double price,
			String specialInstructions) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.specialInstructions = specialInstructions;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public Menu getItemId() {
		return itemId;
	}

	public void setItemId(Menu itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}
	
	
	
}
