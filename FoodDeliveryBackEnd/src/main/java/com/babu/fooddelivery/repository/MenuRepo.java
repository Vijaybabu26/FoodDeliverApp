package com.babu.fooddelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.Menu;

@Repository
@EnableJpaRepositories
public interface MenuRepo extends JpaRepository<Menu, Integer>{
	
	public Optional<Menu> findByItemName(String itemName);

//	public List<Menu> findByResId(Integer resId);

//	public List<Menu> findAllByresId(Integer resId);

}
