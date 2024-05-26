package com.babu.fooddelivery.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Details")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="User_Id")
	private long UserId;
	@Column(name ="User_Name")
	private String UserName;
	@Column(name ="Password")
	private String Password;
	@Column(name ="Email_Id")
	private String EmailId;
	@Column(name ="Phone_No")
	private String PhoneNo;
	@Column(name ="Address")
	private String Address;
	@Column(name ="Profile_Picture")
	private String ProfilePicture;
	@Column(name ="Registration_Date")
	private Date RegistrationDate;
	
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
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
	public String getProfilePicture() {
		return ProfilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		ProfilePicture = profilePicture;
	}
	public Date getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		RegistrationDate = registrationDate;
	}
	public User(int userId, String userName, String password, String emailId, String phoneNo, String address,
			String profilePicture, Date registrationDate) {
		super();
		this.UserId = userId;
		this.UserName = userName;
		this.Password = password;
		this.EmailId = emailId;
		this.PhoneNo = phoneNo;
		this.Address = address;
		this.ProfilePicture = profilePicture;
		this.RegistrationDate = registrationDate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", EmailId=" + EmailId
				+ ", PhoneNo=" + PhoneNo + ", Address=" + Address + ", ProfilePicture=" + ProfilePicture
				+ ", RegistrationDate=" + RegistrationDate + "]";
	}
	
		
}
