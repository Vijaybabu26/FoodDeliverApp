package com.babu.fooddelivery.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.fooddelivery.dto.MenuDTO;
import com.babu.fooddelivery.repository.MenuRepo;

@Service
public class MenuService {
	
	@Autowired
	MenuRepo menurepo;
	
	public MenuDTO AddMenu(MenuDTO menu) {
		return menurepo.save(menu);
	}
	public boolean DeleteMenu(MenuDTO menuitem) {
		Optional<MenuDTO> existingMenu = menurepo.findById(menuitem.getItemId());
		if(existingMenu.isEmpty()) {
			menurepo.delete(existingMenu.get());
			return true;
		}else {
			return false;
		}
	}
	
	public List<MenuDTO> GetRestaurantMenu(Integer ResId){
		return menurepo.FindMenuByResId(ResId);
	}
}
