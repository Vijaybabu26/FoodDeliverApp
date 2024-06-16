package com.babu.fooddelivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant_details")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="resId")
	private Integer resId;
	
	@Column(name ="resName")
	private String resName;
	
	@Column(name ="resPhoneNo",unique = true)
	private String resPhoneNo;
	
	@Column(name ="resPassword")
	private String resPassword;
	
	@Column(name ="resDescription")
	private String resDescription;
	
	@Column(name ="resAddress")
	private String resAddress;
	
	@Column(name ="resOperationHours")
	private String resOperationHours;
	
	@Column(name ="resAvgRating")
	private float resAvgRating;
	
	@Column(name ="resDelievryFee")
	private double resDelievryFee;
	
	@Column(name="resImage")
	private String resImage;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(Integer resId, String resName, String resPhoneNo, String resPassword, String resDescription,
			String resAddress, String resOperationHours, float resAvgRating, double resDelievryFee, String resImage) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resPhoneNo = resPhoneNo;
		this.resPassword = resPassword;
		this.resDescription = resDescription;
		this.resAddress = resAddress;
		this.resOperationHours = resOperationHours;
		this.resAvgRating = resAvgRating;
		this.resDelievryFee = resDelievryFee;
		this.resImage = resImage;
	}

	@Override
	public String toString() {
		return "Restaurant [resId=" + resId + ", resName=" + resName + ", resPhoneNo=" + resPhoneNo + ", resPassword="
				+ resPassword + ", resDescription=" + resDescription + ", resAddress=" + resAddress
				+ ", resOperationHours=" + resOperationHours + ", resAvgRating=" + resAvgRating + ", resDelievryFee="
				+ resDelievryFee + ", resImage=" + resImage + "]";
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResPhoneNo() {
		return resPhoneNo;
	}

	public void setResPhoneNo(String resPhoneNo) {
		this.resPhoneNo = resPhoneNo;
	}

	public String getResPassword() {
		return resPassword;
	}

	public void setResPassword(String resPassword) {
		this.resPassword = resPassword;
	}

	public String getResDescription() {
		return resDescription;
	}

	public void setResDescription(String resDescription) {
		this.resDescription = resDescription;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getResOperationHours() {
		return resOperationHours;
	}

	public void setResOperationHours(String resOperationHours) {
		this.resOperationHours = resOperationHours;
	}

	public float getResAvgRating() {
		return resAvgRating;
	}

	public void setResAvgRating(float resAvgRating) {
		this.resAvgRating = resAvgRating;
	}

	public double getResDelievryFee() {
		return resDelievryFee;
	}

	public void setResDelievryFee(double resDelievryFee) {
		this.resDelievryFee = resDelievryFee;
	}

	public String getResImage() {
		return resImage;
	}

	public void setResImage(String resImage) {
		this.resImage = resImage;
	}
	
	
	
}
