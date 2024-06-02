package com.babu.fooddelivery.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Menu_Items")
public class MenuDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ItemId")
	private Integer ItemId;
	
	@ManyToOne
	@JoinColumn(name= "ResId")
	private RestaurantDTO ResId;
	
	@Column(name = "ItemName")
	private String ItemName;
	
	@Column(name = "ItemDescription")
	private String ItemDescription;
	
	@Column(name ="Price")
	private double Price;
	
	@Column(name = "Category")
	private String Category;
	
	@Column(name = "Availabilty")
	private boolean Availabilty;
	
	@Column(name = "ItemImage")
	private String ItemImage;
	
	public MenuDTO(Integer itemId, RestaurantDTO resId, String itemName, String itemDescription, double price,
			String category, boolean availabilty, String itemImage) {
		super();
		ItemId = itemId;
		ResId = resId;
		ItemName = itemName;
		ItemDescription = itemDescription;
		Price = price;
		Category = category;
		Availabilty = availabilty;
		ItemImage = itemImage;
	}

	@Override
	public String toString() {
		return "MenuDTO [ItemId=" + ItemId + ", ResId=" + ResId + ", ItemName=" + ItemName + ", ItemDescription="
				+ ItemDescription + ", Price=" + Price + ", Category=" + Category + ", Availabilty=" + Availabilty
				+ ", ItemImage=" + ItemImage + "]";
	}

	public MenuDTO() {
		super();
	}

	public Integer getItemId() {
		return ItemId;
	}


	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}

	public RestaurantDTO getResId() {
		return ResId;
	}

	public void setResId(RestaurantDTO resId) {
		ResId = resId;
	}

	public String getItemName() {
		return ItemName;
	}


	public void setItemName(String itemName) {
		ItemName = itemName;
	}


	public String getItemDescription() {
		return ItemDescription;
	}


	public void setItemDescription(String itemDescription) {
		ItemDescription = itemDescription;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}


	public boolean isAvailabilty() {
		return Availabilty;
	}


	public void setAvailabilty(boolean availabilty) {
		Availabilty = availabilty;
	}


	public String getItemImage() {
		return ItemImage;
	}


	public void setItemImage(String itemImage) {
		ItemImage = itemImage;
	}
	
	
	
}
