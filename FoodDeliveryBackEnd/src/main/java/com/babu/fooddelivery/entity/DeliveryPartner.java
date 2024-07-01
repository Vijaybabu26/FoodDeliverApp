package com.babu.fooddelivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="deliverypartner")
public class DeliveryPartner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "deliverypartnerid")
	private Integer deliveryPartnerId;
	
	@Column(name = "dname")
	private String dname;
	
	@Column(name = "demailId")
	private String demailId;
	
	@Column(name = "dphoneNo",unique = true)
	private String dphoneNo;
	
	@Column(name = "dpassword")
	private String password;
		
	@Column(name = "vehicaltype")
	private String vehicletype;
	
	@Column(name = "currlocation")
	private String currlocation;
	
	@Override
	public String toString() {
		return "DeliveryPartner [deliveryPartnerId=" + deliveryPartnerId + ", dname=" + dname + ", demailId=" + demailId
				+ ", dphoneNo=" + dphoneNo + ", password=" + password + ", vehicletype=" + vehicletype
				+ ", currlocation=" + currlocation + "]";
	}
	
	

	public DeliveryPartner() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DeliveryPartner(Integer deliveryPartnerId, String dname, String demailId, String dphoneNo, String password,
			String vehicletype, String currlocation) {
		super();
		this.deliveryPartnerId = deliveryPartnerId;
		this.dname = dname;
		this.demailId = demailId;
		this.dphoneNo = dphoneNo;
		this.password = password;
		this.vehicletype = vehicletype;
		this.currlocation = currlocation;
	}



	public Integer getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(Integer deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDemailId() {
		return demailId;
	}

	public void setDemailId(String demailId) {
		this.demailId = demailId;
	}

	public String getDphoneNo() {
		return dphoneNo;
	}

	public void setDphoneNo(String dphoneNo) {
		this.dphoneNo = dphoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getCurrlocation() {
		return currlocation;
	}

	public void setCurrlocation(String currlocation) {
		this.currlocation = currlocation;
	}

	
	
	
	
	}