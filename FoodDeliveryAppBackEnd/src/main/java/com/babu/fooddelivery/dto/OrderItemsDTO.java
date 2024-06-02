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
public class OrderItemsDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="OrderItemId")
	private Integer OrderItemId;
	
	@ManyToOne
	@JoinColumn(name= "OrderId")
	private OrderDTO OrderId;
	
	@ManyToOne
	@JoinColumn(name= "ItemId")
	private MenuDTO ItemId;
	
	@Column(name = "Quantity")
	private Integer Quantity;
	
	@Column(name = "Price")
	private double Price;
	
	@Column(name = "SpecialInstructions")
	private String SpecialInstructions;
	
	@Override
	public String toString() {
		return "OrderItemsDTO [OrderItemId=" + OrderItemId + ", OrderId=" + OrderId + ", ItemId=" + ItemId
				+ ", Quantity=" + Quantity + ", Price=" + Price + ", SpecialInstructions=" + SpecialInstructions + "]";
	}

	public OrderItemsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemsDTO(Integer orderItemId, OrderDTO orderId, MenuDTO itemId, Integer quantity, double price,
			String specialInstructions) {
		super();
		OrderItemId = orderItemId;
		OrderId = orderId;
		ItemId = itemId;
		Quantity = quantity;
		Price = price;
		SpecialInstructions = specialInstructions;
	}

	public Integer getOrderItemId() {
		return OrderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		OrderItemId = orderItemId;
	}

	public OrderDTO getOrderId() {
		return OrderId;
	}

	public void setOrderId(OrderDTO orderId) {
		OrderId = orderId;
	}

	public MenuDTO getItemId() {
		return ItemId;
	}

	public void setItemId(MenuDTO itemId) {
		ItemId = itemId;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getSpecialInstructions() {
		return SpecialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		SpecialInstructions = specialInstructions;
	}
	
	
}
