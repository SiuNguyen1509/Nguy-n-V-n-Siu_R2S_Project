package com.r2s.Service;

import java.util.List;

import com.r2s.Entity.Category;

public interface CategoryService {

	List<Category> findAll();
	
	Category findById(Integer id);
	
	Category create(Category category);
	

}
