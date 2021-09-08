package com.r2s.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r2s.DAO.CategoryDAO;
import com.r2s.Entity.Category;
import com.r2s.Service.CategoryService;
@Service
public class CategoryImpl implements CategoryService {
@Autowired
CategoryDAO cdao;
	@Override
	public List<Category> findAll() {
	
		return cdao.findAll();
	}
	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}
	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
	}
}
