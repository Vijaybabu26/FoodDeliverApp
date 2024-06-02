package com.babu.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.dto.MenuDTO;

@Repository
public interface MenuRepo extends JpaRepository<MenuDTO, Integer>{

	@Query("SELECT m FROM MenuDTO m WHERE m.ResId = ?1")
	List<MenuDTO> FindMenuByResId(Integer res);
	
}
