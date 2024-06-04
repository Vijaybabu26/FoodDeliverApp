package com.babu.fooddelivery.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurant_Details")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ResId")
public class Restaurant{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ResId")
	private Integer resId;
	
	@Column(name ="ResName")
	private String resName;
	
	@Column(name ="ResDescription")
	private String resDescription;
	
	@Column(name ="ResAddress")
	private String resAddress;
	
	@Column(name ="ResPhoneNo")
	private String resPhoneNo;
	
	@Column(name ="ResOperationHours")
	private String resOperationHours;
	
	@Column(name ="ResAvgRating")
	private float resAvgRating;
	
	@Column(name ="ResDelievryFee")
	private double resDelievryFee;
	
	@Column(name="ResImage")
	private String resImage;

	@Override
	public String toString() {
		return "RestaurantDTO [resId=" + resId + ", resName=" + resName + ", resDescription=" + resDescription
				+ ", resAddress=" + resAddress + ", resPhoneNo=" + resPhoneNo + ", resOperationHours="
				+ resOperationHours + ", resAvgRating=" + resAvgRating + ", resDelievryFee=" + resDelievryFee
				+ ", resImage=" + resImage + "]";
	}

	public Restaurant(Integer resId, String resName, String resDescription, String resAddress, String resPhoneNo,
			String resOperationHours, float resAvgRating, double resDelievryFee, String resImage) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resDescription = resDescription;
		this.resAddress = resAddress;
		this.resPhoneNo = resPhoneNo;
		this.resOperationHours = resOperationHours;
		this.resAvgRating = resAvgRating;
		this.resDelievryFee = resDelievryFee;
		this.resImage = resImage;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getResPhoneNo() {
		return resPhoneNo;
	}

	public void setResPhoneNo(String resPhoneNo) {
		this.resPhoneNo = resPhoneNo;
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
