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
@Table(name = "Delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="deliveryId")
	private Integer deliveryId;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order orderId;
	
	@ManyToOne
	@JoinColumn(name = "deliveryPartnerId")
	private DeliveryPartner deliveryPartnerId;
	
	@ManyToOne
	@JoinColumn(name = "status")
	private Order status;
	
	@ManyToOne
	@JoinColumn(name ="deliveryTime")
	private Order deliveryTime;
	
	@Column(name ="estimatedtimeofarrival")
	private LocalDateTime estimatedtimeofarrival;
	
	@Column(name = "actualtimeofarrival")
	private LocalDateTime actualtimeofarrival;

	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", orderId=" + orderId + ", deliveryPartnerId="
				+ deliveryPartnerId + ", status=" + status + ", deliveryTime=" + deliveryTime
				+ ", estimatedtimeofarrival=" + estimatedtimeofarrival + ", actualtimeofarrival=" + actualtimeofarrival
				+ "]";
	}

	public Delivery() {
		super();
	}

	public Delivery(Integer deliveryId, Order orderId, DeliveryPartner deliveryPartnerId, Order status,
			Order deliveryTime, LocalDateTime estimatedtimeofarrival, LocalDateTime actualtimeofarrival) {
		super();
		this.deliveryId = deliveryId;
		this.orderId = orderId;
		this.deliveryPartnerId = deliveryPartnerId;
		this.status = status;
		this.deliveryTime = deliveryTime;
		this.estimatedtimeofarrival = estimatedtimeofarrival;
		this.actualtimeofarrival = actualtimeofarrival;
	}

	public Integer getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public DeliveryPartner getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(DeliveryPartner deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public Order getStatus() {
		return status;
	}

	public void setStatus(Order status) {
		this.status = status;
	}

	public Order getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Order deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public LocalDateTime getEstimatedtimeofarrival() {
		return estimatedtimeofarrival;
	}

	public void setEstimatedtimeofarrival(LocalDateTime estimatedtimeofarrival) {
		this.estimatedtimeofarrival = estimatedtimeofarrival;
	}

	public LocalDateTime getActualtimeofarrival() {
		return actualtimeofarrival;
	}

	public void setActualtimeofarrival(LocalDateTime actualtimeofarrival) {
		this.actualtimeofarrival = actualtimeofarrival;
	}
	
	
	
}
