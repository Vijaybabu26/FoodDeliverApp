package com.babu.fooddelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.babu.fooddelivery.entity.Menu;

@Repository
@EnableJpaRepositories
public interface MenuRepo extends JpaRepository<Menu, Integer>{
	
	public Optional<Menu> findByItemName(String itemName);

	@Query("SELECT m FROM Menu m JOIN m.resId r WHERE r.resId = :resId")
	List<Menu> findByResId(@Param("resId") Integer resId);

}
