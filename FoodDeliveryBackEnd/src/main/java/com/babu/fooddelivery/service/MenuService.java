package com.babu.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.entity.Menu;
import com.babu.fooddelivery.repository.MenuRepo;

@Service
public class MenuService {
	
	@Autowired
	MenuRepo menurepo;
	
	public String additem(Menu menu) {
		menurepo.save(menu);
		return menu.getItemName() + "Item Added SuccessFull";
	}
	
	public List<Menu> GetRestaurantMenu(Integer resId){
		List<Menu> menu = menurepo.findByResId(resId);
		return menu;
	}
}
