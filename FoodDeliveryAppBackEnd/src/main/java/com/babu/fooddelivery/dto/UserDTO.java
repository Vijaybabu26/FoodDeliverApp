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
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="UserId")
	private Integer UserId;
	
	@Column(name ="UserName")
	private String UserName;
	
	@Column(name ="Password")
	private String Password;
	
	@Column(name ="EmailId")
	private String EmailId;
	
	@Column(name ="PhoneNo")
	private String PhoneNo;
	
	@Column(name ="Address")
	private String Address;
	
	@Column(name ="RegistrationDate")
	private LocalDateTime RegistrationDate;
	
	@Column(name = "ProfilePicture")
	private String ProfilePicture;
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserDTO(Integer userId, String userName, String password, String emailId, String phoneNo, String address,
			LocalDateTime registrationDate, String profilePicture) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
		EmailId = emailId;
		PhoneNo = phoneNo;
		Address = address;
		RegistrationDate = registrationDate;
		ProfilePicture = profilePicture;
	}



	@Override
	public String toString() {
		return "UserDTO [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", EmailId="
				+ EmailId + ", PhoneNo=" + PhoneNo + ", Address=" + Address + ", RegistrationDate=" + RegistrationDate
				+ ", ProfilePicture=" + ProfilePicture + "]";
	}



	public String getProfilePicture() {
		return ProfilePicture;
	}



	public void setProfilePicture(String profilePicture) {
		ProfilePicture = profilePicture;
	}



	public Integer getUserId() {
		return UserId;
	}



	public void setUserId(Integer userId) {
		UserId = userId;
	}



	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public LocalDateTime getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(LocalDateTime stamp) {
		RegistrationDate = stamp;
	}
	
	
}
