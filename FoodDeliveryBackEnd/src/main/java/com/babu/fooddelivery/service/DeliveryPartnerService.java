package com.babu.fooddelivery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.entity.DeliveryPartner;
import com.babu.fooddelivery.repository.DeliveryPartnerRepo;

@Service
public class DeliveryPartnerService {
	
	@Autowired
	DeliveryPartnerRepo dprepo;
	
	public String registerDeliveryPartner(DeliveryPartner deliverypartner) {
		dprepo.save(deliverypartner);
		return deliverypartner.getDname() + "Registration Successfull";
	}
	
	public Optional<DeliveryPartner> getDeliveryPartnerDetails(String phno){
		return dprepo.findDpBydphoneNo(phno);
	}
	
}
