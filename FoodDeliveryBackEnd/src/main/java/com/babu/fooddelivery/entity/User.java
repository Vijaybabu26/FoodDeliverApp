package com.babu.fooddelivery.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="userId")
	private Integer userId;
	
//	@Column(name = "profilePicture")
//	private byte[] profilePicture;
	
	@Column(name ="userName")
	private String userName;
	
	@Column(name ="password")
	private String password;
	
	@Column(name ="emailId")
	private String emailId;
	

	@Column(unique = true)
	private String phoneNo;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="registrationDate")
	private LocalDateTime registrationDate;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", emailId=" + emailId
				+ ", phoneNo=" + phoneNo + ", address=" + address + ", registrationDate=" + registrationDate + "]";
	}

	public User(Integer userId, String userName, String password, String emailId, String phoneNo, String address,
			LocalDateTime registrationDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.address = address;
		this.registrationDate = registrationDate;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	

	
}
