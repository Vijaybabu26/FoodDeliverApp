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
@Table(name="Menu_Items")
public class MenuItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_Id")
	private long ItemId;
	
	@ManyToOne
	@JoinColumn(name="Restaurant_Id", referencedColumnName ="Restaurant_Id")
	private long RestaurantId;
	
	@Column(name="Item_Name")
	private String Name;
	
	@Column(name="Item_Description")
	private String Description;
	
	@Column(name="Item_Price")
	private double Price;
	
	@Column(name="Item_Category")
	private String Category;
	
	@Column(name="Availability")
	private boolean Availabilty;
	
	@Column(name="Item_Image")
	private String Image;
	
	public long getItemId() {
		return ItemId;
	}
	public void setItemId(long itemId) {
		ItemId = itemId;
	}
	public long getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public MenuItems(long itemId, long restaurantId, String name, String description, double price, String category,
			boolean availabilty, String image) {
		super();
		this.ItemId = itemId;
		this.RestaurantId = restaurantId;
		this.Name = name;
		this.Description = description;
		this.Price = price;
		this.Category = category;
		this.Availabilty = availabilty;
		this.Image = image;
	}
	@Override
	public String toString() {
		return "MenuItems [ItemId=" + ItemId + ", RestaurantId=" + RestaurantId + ", Name=" + Name + ", Description="
				+ Description + ", Price=" + Price + ", Category=" + Category + ", Availabilty=" + Availabilty
				+ ", Image=" + Image + "]";
	}
	public MenuItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
