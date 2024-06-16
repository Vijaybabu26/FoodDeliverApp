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
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymenyId")
	private Integer paymentId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "ordereId")
	private Orders ordereId;
	
	@Column(name = "paymentdate")
	private LocalDateTime paymentdate;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "paymentMethod")
	private String paymentMethod;
	
	@Column(name = "transactionId")
	private String transactionId;
	
	
	
	public Payment() {
		super();
	}

	public Payment(Integer paymentId, User userId, Orders ordereId, LocalDateTime paymentdate, double amount,
			String paymentMethod, String transactionId) {
		super();
		this.paymentId = paymentId;
		this.userId = userId;
		this.ordereId = ordereId;
		this.paymentdate = paymentdate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", userId=" + userId + ", ordereId=" + ordereId + ", paymentdate="
				+ paymentdate + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", transactionId="
				+ transactionId + "]";
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Orders getOrdereId() {
		return ordereId;
	}

	public void setOrdereId(Orders ordereId) {
		this.ordereId = ordereId;
	}

	public LocalDateTime getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(LocalDateTime paymentdate) {
		this.paymentdate = paymentdate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
}