package com.babu.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.dto.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.phoneNo = ?1")
	User findByPhoneNo(String phoneNo);
	
}
