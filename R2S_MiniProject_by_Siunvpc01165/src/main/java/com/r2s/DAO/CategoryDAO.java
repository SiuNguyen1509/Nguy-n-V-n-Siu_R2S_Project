package com.r2s.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.r2s.Entity.Category;



public interface CategoryDAO extends JpaRepository<Category, String>{
	
	Optional<Category> findById(Integer id);
	
	
}
