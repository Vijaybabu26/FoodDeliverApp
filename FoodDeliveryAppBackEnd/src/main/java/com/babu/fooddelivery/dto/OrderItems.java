package com.babu.fooddelivery.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Order_Items")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="OrderItemId")
	private Integer orderItemId;
	
	@ManyToOne
	@JoinColumn(name= "OrderId")
	private Order orderId;
	
	@ManyToOne
	@JoinColumn(name= "ItemId")
	private Menu itemId;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "SpecialInstructions")
	private String specialInstructions;

	public OrderItems(Integer orderItemId, Order orderId, Menu itemId, Integer quantity, double price,
			String specialInstructions) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.specialInstructions = specialInstructions;
	}

	
	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemId=" + itemId + ", quantity="
				+ quantity + ", price=" + price + ", specialInstructions=" + specialInstructions + "]";
	}


	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
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
