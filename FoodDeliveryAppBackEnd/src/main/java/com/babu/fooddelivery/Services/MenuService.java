package com.babu.fooddelivery.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.Menu;
import com.babu.fooddelivery.repository.MenuRepo;

@Service
public class MenuService {
	
	@Autowired
	MenuRepo menurepo;
	
	public Menu AddMenu(Menu menu) {
		return menurepo.save(menu);
	}
	public boolean DeleteMenu(Menu menuitem) {
		Optional<Menu> existingMenu = menurepo.findById(menuitem.getItemId());
		if(existingMenu.isEmpty()) {
			menurepo.delete(existingMenu.get());
			return true;
		}else {
			return false;
		}
	}
	
	public List<Menu> GetRestaurantMenu(Integer ResId){
		return menurepo.FindMenuByResId(ResId);
	}
}
