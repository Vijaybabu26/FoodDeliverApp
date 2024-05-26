package com.babu.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.fooddelivery.dto.User;

public interface UserRepo extends JpaRepository<User,Long>{
	
}
