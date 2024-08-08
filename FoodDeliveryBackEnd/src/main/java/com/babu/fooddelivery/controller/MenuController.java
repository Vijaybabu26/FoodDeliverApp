package com.babu.fooddelivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.entity.Menu;
import com.babu.fooddelivery.repository.MenuRepo;
import com.babu.fooddelivery.service.MenuService;

@RestController
@CrossOrigin
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired
	MenuRepo menurepo;
	
	@Autowired
	MenuService menuser;
	
	@PostMapping("/additem")
	public ResponseEntity<String> additem(@RequestBody Menu menu){
		String itemName = menu.getItemName();
		Optional<Menu> existingitem = menurepo.findByItemName(itemName);
		if(existingitem.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Item with Same Name " + itemName + " already exists.");
		}else if(menuser.additem(menu) != null ) {
			String message = "item Added Succesfull";
			System.out.println(menu);
			return ResponseEntity.status(HttpStatus.CREATED).body(menu.getItemName() + " " + message);
		}
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item Adding Failed due to invalid data.");
	}
	
	
	@PostMapping("/edititem")
	public ResponseEntity<String> editItem(@RequestBody Menu menu) {
	    Optional<Menu> existingItemOpt = menurepo.findById(menu.getItemId());
	    if (existingItemOpt.isPresent()) {
	        Menu existingItem = existingItemOpt.get();
	        existingItem.setItemName(menu.getItemName());
	        existingItem.setItemDescription(menu.getItemDescription());
	        existingItem.setItemImage(menu.getItemImage());
	        existingItem.setAvailabilty(menu.isAvailabilty());
	        existingItem.setCategory(menu.getCategory());
	        existingItem.setPrice(menu.getPrice());
	        existingItem.setResId(menu.getResId());
	        menurepo.save(existingItem);
	        String message = "Item Edited Successfully";
	        System.out.println(existingItem);
	        return ResponseEntity.status(HttpStatus.OK).body(menu.getItemName() + " " + message);
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found for editing.");
	}

	
	@PostMapping("/deleteitem/{itemName}")
	public ResponseEntity<Menu> deleteitem(@PathVariable("itemName") String itemName){
		String itemname = itemName.toString();
		Optional<Menu> menu = menurepo.findByItemName(itemname);
		if(menu.isPresent()) {
			Menu menu1 = menu.get();
			Integer DeleteId = menu1.getItemId();
			menurepo.deleteById(DeleteId);
			return new ResponseEntity<>(menu1, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/restaurantmenu")
//	public ResponseEntity<List<Menu>> getRestaurantMenu(@RequestBody Menu menu){
//		Restaurant res = menu.getResId();
//		List<Menu> menulist = menuser.GetRestaurantMenu(res.getResId());
//		if(menulist.isEmpty()) {
//			System.out.println("Not Found");
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
//			
//		}
//		
//		return new ResponseEntity<>(menulist,HttpStatus.OK);	
//	}
	
	@GetMapping("/restaurantmenu/{resId}")
	public ResponseEntity<List<Menu>> getRestaurantMenulist(@PathVariable("resId") Integer resId){
		List<Menu> menulist = menuser.GetRestaurantMenu(resId);
		if(menulist.isEmpty()) {
			System.out.println("Not Found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
			
		}
		
		return new ResponseEntity<>(menulist,HttpStatus.OK);	
		
	}
	
	
}
