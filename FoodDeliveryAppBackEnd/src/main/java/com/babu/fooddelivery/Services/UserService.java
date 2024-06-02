package com.babu.fooddelivery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.UserDTO;
import com.babu.fooddelivery.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userrepo;

	public UserDTO registerUser (UserDTO user) {
		return userrepo.save(user);
	}
	
	public UserDTO getUserWithAccounts(String PhoneNo) {
	    return userrepo.FindUserbyphno(PhoneNo);
	} 
}
