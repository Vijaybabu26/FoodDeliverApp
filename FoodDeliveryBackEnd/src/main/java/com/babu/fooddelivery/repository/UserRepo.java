package com.babu.fooddelivery.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public Optional<User> findByPhoneNo(String phoneNo);

}
