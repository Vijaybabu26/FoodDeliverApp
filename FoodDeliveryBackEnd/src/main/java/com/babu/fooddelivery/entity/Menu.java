package com.babu.fooddelivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_Items")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ItemId")
	private Integer itemId;
	
	@ManyToOne
	@JoinColumn(name= "resId")
	private Restaurant resId;
	
	@Column(name = "itemName",unique = true)
	private String itemName;
	
	@Column(name = "itemDescription")
	private String itemDescription;
	
	@Column(name ="price")
	private double price;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "availabilty")
	private boolean availabilty;
	
	@Column(name = "itemImage")
	private String itemImage;

	@Override
	public String toString() {
		return "Menu [itemId=" + itemId + ", resId=" + resId + ", itemName=" + itemName + ", itemDescription="
				+ itemDescription + ", price=" + price + ", category=" + category + ", availabilty=" + availabilty
				+ ", itemImage=" + itemImage + "]";
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(Integer itemId, Restaurant resId, String itemName, String itemDescription, double price,
			String category, boolean availabilty, String itemImage) {
		super();
		this.itemId = itemId;
		this.resId = resId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.price = price;
		this.category = category;
		this.availabilty = availabilty;
		this.itemImage = itemImage;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Restaurant getResId() {
		return resId;
	}

	public void setResId(Restaurant resId) {
		this.resId = resId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(boolean availabilty) {
		this.availabilty = availabilty;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	
	
	
}
