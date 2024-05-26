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
@Table(name= "Order_Items")
public class OrderItems {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="Order_Item_Id")
		private long OrderItemId;
		
		@ManyToOne
		@JoinColumn(name="Order_Id", referencedColumnName ="Order_Id")
		private long OrderId;
		
		@ManyToOne
		@JoinColumn(name="Item_Id", referencedColumnName ="Item_Id")
		private long ItemId;
		
		@Column(name ="Quantity")
		private long Quantity;
		
		@Column(name = "Price")
		private double Price;
		
		@Column(name = "Special_Instructions")
		private String SpecialInstructions;

		public long getOrderItemId() {
			return OrderItemId;
		}

		public void setOrderItemId(long orderItemId) {
			OrderItemId = orderItemId;
		}

		public long getOrderId() {
			return OrderId;
		}

		public void setOrderId(long orderId) {
			OrderId = orderId;
		}

		public long getItemId() {
			return ItemId;
		}

		public void setItemId(long itemId) {
			ItemId = itemId;
		}

		public long getQuantity() {
			return Quantity;
		}

		public void setQuantity(long quantity) {
			Quantity = quantity;
		}

		public double getPrice() {
			return Price;
		}

		public void setPrice(double price) {
			Price = price;
		}

		public String getSpecialInstructions() {
			return SpecialInstructions;
		}

		public void setSpecialInstructions(String specialInstructions) {
			SpecialInstructions = specialInstructions;
		}

		public OrderItems(long orderItemId, long orderId, long itemId, long quantity, double price,
				String specialInstructions) {
			super();
			this.OrderItemId = orderItemId;
			this.OrderId = orderId;
			this.ItemId = itemId;
			this.Quantity = quantity;
			this.Price = price;
			this.SpecialInstructions = specialInstructions;
		}

		public OrderItems() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "OrderItems [OrderItemId=" + OrderItemId + ", OrderId=" + OrderId + ", ItemId=" + ItemId
					+ ", Quantity=" + Quantity + ", Price=" + Price + ", SpecialInstructions=" + SpecialInstructions
					+ "]";
		}
		
		
		
	
}
