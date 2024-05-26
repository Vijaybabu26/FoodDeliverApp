package com.babu.fooddelivery.dto;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurant_Details")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Restaurant_Id")
	private long RestaurantId;
	
	@Column(name = "Restaurant_Name")
	private String RestaurantName;
	
	@Column(name = "Restaurant_Desc")
	private String RestaurantDesc;
	
	@Column(name = "Restaurant_Address")
	private String RestaurantAddress;
	
	@Column(name = "Restaurant_Phno")
	private String RestaurantPhno;
	
	@Column(name = "Restaurant_Opening_Hours")
	private String RestaurantOpeningHours;
	
	@Column(name = "Restaurant_Average_Rating")
	private float RestaurantAverageRating;
	
	@Column(name = "Restaurant_Delivery_Fee")
	private double RestaurantDeliveryFee;
	
	@Column(name = "Restaurant_Logo")
	private String RestaurantLogo;
	
	public long getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return RestaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}
	public String getRestaurantDesc() {
		return RestaurantDesc;
	}
	public void setRestaurantDesc(String restaurantDesc) {
		RestaurantDesc = restaurantDesc;
	}
	public String getRestaurantAddress() {
		return RestaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		RestaurantAddress = restaurantAddress;
	}
	public String getRestaurantPhno() {
		return RestaurantPhno;
	}
	public void setRestaurantPhno(String restaurantPhno) {
		RestaurantPhno = restaurantPhno;
	}
	public String getRestaurantOpeningHours() {
		return RestaurantOpeningHours;
	}
	public void setRestaurantOpeningHours(String restaurantOpeningHours) {
		RestaurantOpeningHours = restaurantOpeningHours;
	}
	public float getRestaurantAverageRating() {
		return RestaurantAverageRating;
	}
	public void setRestaurantAverageRating(float restaurantAverageRating) {
		RestaurantAverageRating = restaurantAverageRating;
	}
	public double getRestaurantDeliveryFee() {
		return RestaurantDeliveryFee;
	}
	public void setRestaurantDeliveryFee(double restaurantDeliveryFee) {
		RestaurantDeliveryFee = restaurantDeliveryFee;
	}
	public String getRestaurantLogo() {
		return RestaurantLogo;
	}
	public void setRestaurantLogo(String restaurantLogo) {
		RestaurantLogo = restaurantLogo;
	}
	public Restaurant(long restaurantId, String restaurantName, String restaurantDesc, String restaurantAddress,
			String restaurantPhno, String restaurantOpeningHours, float restaurantAverageRating,
			double restaurantDeliveryFee, String restaurantLogo) {
		super();
		this.RestaurantId = restaurantId;
		this.RestaurantName = restaurantName;
		this.RestaurantDesc = restaurantDesc;
		this.RestaurantAddress = restaurantAddress;
		this.RestaurantPhno = restaurantPhno;
		this.RestaurantOpeningHours = restaurantOpeningHours;
		this.RestaurantAverageRating = restaurantAverageRating;
		this.RestaurantDeliveryFee = restaurantDeliveryFee;
		this.RestaurantLogo = restaurantLogo;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Restaurant [RestaurantId=" + RestaurantId + ", RestaurantName=" + RestaurantName + ", RestaurantDesc="
				+ RestaurantDesc + ", RestaurantAddress=" + RestaurantAddress + ", RestaurantPhno=" + RestaurantPhno
				+ ", RestaurantOpeningHours=" + RestaurantOpeningHours + ", RestaurantAverageRating="
				+ RestaurantAverageRating + ", RestaurantDeliveryFee=" + RestaurantDeliveryFee + ", RestaurantLogo="
				+ RestaurantLogo + "]";
	}
	
	
	

}
