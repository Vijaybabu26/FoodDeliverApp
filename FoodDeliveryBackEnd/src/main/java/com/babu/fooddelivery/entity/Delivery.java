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
@Table(name = "Delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="deliveryId")
	private Integer deliveryId;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orders orderId;
	
	@ManyToOne
	@JoinColumn(name = "deliveryPartnerId")
	private DeliveryPartner deliveryPartnerId;
	
	@ManyToOne
	@JoinColumn(name = "status")
	private Orders status;
	
	@ManyToOne
	@JoinColumn(name ="deliveryTime")
	private Orders deliveryTime;
	
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

	public Delivery(Integer deliveryId, Orders orderId, DeliveryPartner deliveryPartnerId, Orders status,
			Orders deliveryTime, LocalDateTime estimatedtimeofarrival, LocalDateTime actualtimeofarrival) {
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

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public DeliveryPartner getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(DeliveryPartner deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public Orders getStatus() {
		return status;
	}

	public void setStatus(Orders status) {
		this.status = status;
	}

	public Orders getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Orders deliveryTime) {
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