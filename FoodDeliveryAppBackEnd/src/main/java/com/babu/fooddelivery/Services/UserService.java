package com.babu.fooddelivery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.User;

import com.babu.fooddelivery.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userrepo;

	public User registerUser (User user) {
		return userrepo.save(user);
	}
	
	 public boolean getUserWithAccounts(String phno) {
	    return userrepo.findByPhoneNo(phno)!= null;
	 }
}
