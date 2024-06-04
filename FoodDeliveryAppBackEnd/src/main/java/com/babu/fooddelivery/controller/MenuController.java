package com.babu.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babu.fooddelivery.Services.MenuService;
import com.babu.fooddelivery.dto.Menu;


@RestController
@RequestMapping(value ="/api/Menu")
public class MenuController {
	
	@Autowired
	MenuService menuser;
	
	@PostMapping("/AddItem")
	public ResponseEntity<String> AddMenuItem(@RequestBody Menu menu){
		if(menuser.AddMenu(menu) != null) {
			String Message = "Item Added To Menu Successfull";
			return ResponseEntity.ok(Message);
		}
		return ResponseEntity.ok("Item Adding To Menu Failed");
	}
	
	public ResponseEntity<String> DeleteItem(@RequestBody Menu menu){
		if(menuser.DeleteMenu(menu)) {
			String Message = "Item Deleted From Menu Successfull";
			return ResponseEntity.ok(Message);
		}
		return ResponseEntity.ok("Item Deleting From Menu Failed");
	}
	
	@GetMapping("/menu/{ResId}")
	public ResponseEntity<List<Menu>> GetMenuOfRestaurant(@PathVariable Integer ResId){
		List<Menu> menu = menuser.GetRestaurantMenu(ResId);
		if(menu != null) {
			return ResponseEntity.ok(menu);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
