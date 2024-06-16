package com.babu.fooddelivery.service;





import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.babu.fooddelivery.entity.User;
import com.babu.fooddelivery.repository.UserRepo;


@Service
public class UserService {

	@Autowired
	UserRepo userrepo;

	 
	public String registeruser(User user) {
		
        LocalDateTime currentTime = LocalDateTime.now();
        
        user.setRegistrationDate(currentTime);

		userrepo.save(user);
		return user.getUserName() +"Registration Successfull";
	}
	
	 
	   public Optional<User> getUserDetails(String phoneNo) {
		   return this.userrepo.findByPhoneNo(phoneNo);
	   }
}
