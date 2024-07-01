package com.babu.fooddelivery.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.entity.DeliveryPartner;
import com.babu.fooddelivery.repository.DeliveryPartnerRepo;
import com.babu.fooddelivery.service.DeliveryPartnerService;

@RestController
@CrossOrigin
@RequestMapping("api/deliverypartner")
public class DeliveryPartnerController {
	
	@Autowired
	DeliveryPartnerService dpser;
	
	@Autowired
	DeliveryPartnerRepo dprepo;
	
	@PostMapping("/registerdp")
	public ResponseEntity<String> registerDeliveryPartner(@RequestBody DeliveryPartner delp){
		
		String dpphno = delp.getDphoneNo();
		Optional<DeliveryPartner> existingdelpartner = dprepo.findDpBydphoneNo(dpphno);
		if(existingdelpartner.isPresent()) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).body("Delivery Partner with phone number " + dpphno + " already exists.");
		}else if(dpser.registerDeliveryPartner(delp) != null) {
			String message = "Delivery Partner Registration SuccessFull";
			System.out.println(delp);
			return ResponseEntity.status(HttpStatus.CREATED).body(delp.getDname()+ " " + message);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Failed due to invalid data.");
	}
	
	@PostMapping("/updatedp")
	public ResponseEntity<String> updateDeliveryPartner(@RequestBody DeliveryPartner deliveryp){
		
		Optional<DeliveryPartner> existingDeliveryPartner = dprepo.findById(deliveryp.getDeliveryPartnerId());
		
		if(existingDeliveryPartner.isPresent()) {
			DeliveryPartner partner = existingDeliveryPartner.get();
			partner.setDeliveryPartnerId(partner.getDeliveryPartnerId());
			partner.setDname(deliveryp.getDname());
			partner.setDphoneNo(deliveryp.getDphoneNo());
			partner.setDemailId(deliveryp.getDemailId());
			partner.setPassword(deliveryp.getPassword());
			partner.setVehicletype(deliveryp.getVehicletype());
			partner.setCurrlocation(deliveryp.getCurrlocation());
			
			dprepo.save(partner);
			String message = "Partner Details Updated Successfull";
			System.out.println(partner);
			return ResponseEntity.status(HttpStatus.OK).body(partner.getDname() + " " + message);
		}else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delivery Partner Details Not Updated");
	    }
		
	}
	
	
	@PostMapping("/logindeliverypartner")
	public ResponseEntity<String> loginDeliveryPartner(@RequestBody DeliveryPartner partner){
		String phno = partner.getDphoneNo();
		String password = partner.getPassword();
		Optional<DeliveryPartner> delivery = dpser.getDeliveryPartnerDetails(phno);
		DeliveryPartner dpartner = delivery.get();
		String passworde = dpartner.getPassword();
		if(delivery.isPresent()) {
			if(password.equals(passworde)) {
				System.out.println("LOGin S");
				 UUID uuid = UUID.randomUUID();
				 String Token = (uuid.toString()).toUpperCase();
				 return ResponseEntity.ok("Login SuccessFull" + " " + partner.getDphoneNo() + " " + dpartner.getDemailId() + " "+ Token);
			}
		}
		System.out.println("Login f");
		return ResponseEntity.ok("Login Failed");
	}
	
	
//	@GetMapping("/getDeliveryPartner/{dphoneNo}")
//	public ResponseEntity<DeliveryPartner> retriveDeliveryDetails(@PathVariable("phoneNo") String dphoneNo){
//		String phno = dphoneNo.toString();
//		Optional<DeliveryPartner> dpartner = dpser.getDeliveryPartnerDetails(phno);
//		System.out.println(phno);
//		if(dpartner.isPresent()) {
//			DeliveryPartner deliveryp = dpartner.get();
//			System.out.println(deliveryp);
//			return new ResponseEntity<>(deliveryp, HttpStatus.OK); 
//		}else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
	@GetMapping("/getDeliveryPartner/{dphoneNo}")
	public ResponseEntity<DeliveryPartner> retrieveDeliveryDetails(@PathVariable("dphoneNo") String dphoneNo) {
	    String phno = dphoneNo.toString();
	    Optional<DeliveryPartner> dpartner = dpser.getDeliveryPartnerDetails(phno);
	    System.out.println(phno);
	    if (dpartner.isPresent()) {
	        DeliveryPartner deliveryp = dpartner.get();
	        System.out.println(deliveryp);
	        return new ResponseEntity<>(deliveryp, HttpStatus.OK);
	    }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
