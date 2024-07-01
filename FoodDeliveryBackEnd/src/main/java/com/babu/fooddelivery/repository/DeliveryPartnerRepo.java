package com.babu.fooddelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.DeliveryPartner;

@Repository
@EnableJpaRepositories
public interface DeliveryPartnerRepo extends JpaRepository<DeliveryPartner, Integer>{
	
	public Optional<DeliveryPartner> findDpBydphoneNo(String dphoneNo);
	
}
