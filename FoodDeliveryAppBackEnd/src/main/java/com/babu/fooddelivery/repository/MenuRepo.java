package com.babu.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.dto.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer>{

	@Query("SELECT m FROM Menu m WHERE m.resId = ?1")
	List<Menu> FindMenuByResId(Integer res);
	
}
