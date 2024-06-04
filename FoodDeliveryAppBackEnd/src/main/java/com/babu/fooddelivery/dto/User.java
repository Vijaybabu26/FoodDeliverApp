package com.babu.fooddelivery.dto;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Details")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "UserId")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="UserId")
	private Integer userId;
	
	@Column(name ="UserName")
	private String userName;
	
	@Column(name ="Password")
	private String password;
	
	@Column(name ="EmailId")
	private String emailId;
	
	@Column(name ="PhoneNo")
	private String phoneNo;
	
	@Column(name ="Address")
	private String address;
	
	@Column(name ="RegistrationDate")
	private LocalDateTime registrationDate;
	
	@Column(name = "ProfilePicture")
	private String profilePicture;

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", emailId="
				+ emailId + ", phoneNo=" + phoneNo + ", address=" + address + ", registrationDate=" + registrationDate
				+ ", profilePicture=" + profilePicture + "]";
	}

	public User(Integer userId, String userName, String password, String emailId, String phoneNo, String address,
			LocalDateTime registrationDate, String profilePicture) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.address = address;
		this.registrationDate = registrationDate;
		this.profilePicture = profilePicture;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
	
	
	
}
