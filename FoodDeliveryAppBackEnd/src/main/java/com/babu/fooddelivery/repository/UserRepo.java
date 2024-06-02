package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.dto.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Long>{
	
	@Query("SELECT u FROM UserDTO u WHERE u.PhoneNo = ?1")
	UserDTO FindUserbyphno(String PhoneNo);
	
}
