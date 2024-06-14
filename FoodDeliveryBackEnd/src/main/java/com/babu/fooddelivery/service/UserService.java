package com.babu.fooddelivery.service;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.UserDTO;
import com.babu.fooddelivery.entity.User;
import com.babu.fooddelivery.repository.UserRepo;


@Service
public class UserService {

	@Autowired
	UserRepo userrepo;

	 
	public String registeruser(UserDTO userdto) {
		
		User user = new User(
				
				userdto.getUserName(),
				userdto.getPhoneNo(),
				userdto.getEmailId(),
				userdto.getPassword(),
				userdto.getAddress(), userdto.getRegistrationDate()
		);
		System.out.println("UserDTO");

		userrepo.save(user);
		return user.getUserName() +"Registration Successfull";
	}
	
	 
	   public User getUserDetails(String phoneNo) {
		   return this.userrepo.findByPhoneNo(phoneNo);
	   }
}
