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
public class RestaurantDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ResId")
	private Integer ResId;
	
	@Column(name ="ResName")
	private String ResName;
	
	@Column(name ="ResDescription")
	private String ResDescription;
	
	@Column(name ="ResAddress")
	private String ResAddress;
	
	@Column(name ="ResPhoneNo")
	private String ResPhoneNo;
	
	@Column(name ="ResOperationHours")
	private String ResOperationHours;
	
	@Column(name ="ResAvgRating")
	private float ResAvgRating;
	
	@Column(name ="ResDelievryFee")
	private double ResDelievryFee;
	
	@Column(name="ResImage")
	private String ResImage;
	
	
	public RestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantDTO(Integer resId, String resName, String resDescription, String resAddress, String resPhoneNo,
			String resOperationHours, float resAvgRating, double resDelievryFee, String resImage) {
		super();
		ResId = resId;
		ResName = resName;
		ResDescription = resDescription;
		ResAddress = resAddress;
		ResPhoneNo = resPhoneNo;
		ResOperationHours = resOperationHours;
		ResAvgRating = resAvgRating;
		ResDelievryFee = resDelievryFee;
		ResImage = resImage;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [ResId=" + ResId + ", ResName=" + ResName + ", ResDescription=" + ResDescription
				+ ", ResAddress=" + ResAddress + ", ResPhoneNo=" + ResPhoneNo + ", ResOperationHours="
				+ ResOperationHours + ", ResAvgRating=" + ResAvgRating + ", ResDelievryFee=" + ResDelievryFee
				+ ", ResImage=" + ResImage + "]";
	}

	public String getResImage() {
		return ResImage;
	}

	public void setResImage(String resImage) {
		ResImage = resImage;
	}
	public Integer getResId() {
		return ResId;
	}

	public void setResId(Integer resId) {
		ResId = resId;
	}

	public String getResName() {
		return ResName;
	}

	public void setResName(String resName) {
		ResName = resName;
	}

	public String getResDescription() {
		return ResDescription;
	}

	public void setResDescription(String resDescription) {
		ResDescription = resDescription;
	}

	public String getResAddress() {
		return ResAddress;
	}

	public void setResAddress(String resAddress) {
		ResAddress = resAddress;
	}

	public String getResPhoneNo() {
		return ResPhoneNo;
	}

	public void setResPhoneNo(String resPhoneNo) {
		ResPhoneNo = resPhoneNo;
	}

	public String getResOperationHours() {
		return ResOperationHours;
	}

	public void setResOperationHours(String resOperationHours) {
		ResOperationHours = resOperationHours;
	}

	public float getResAvgRating() {
		return ResAvgRating;
	}

	public void setResAvgRating(float resAvgRating) {
		ResAvgRating = resAvgRating;
	}

	public double getResDelievryFee() {
		return ResDelievryFee;
	}

	public void setResDelievryFee(double resDelievryFee) {
		ResDelievryFee = resDelievryFee;
	}
	
	
}
