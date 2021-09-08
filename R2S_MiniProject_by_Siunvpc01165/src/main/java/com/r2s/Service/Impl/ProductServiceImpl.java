package com.r2s.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r2s.DAO.ProductDAO;
import com.r2s.Entity.Product;
import com.r2s.Service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO pDao;

	@Override
	public List<Product> findAll() {
		return pDao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return pDao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub
		return pDao.findByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pDao.save(product);
	}

	@Override
	public Product update(Product product) {
		
		return pDao.save(product);
	}

	

	@Override
	public void deletefindById(Integer id) {
		/* proDao.findById(id); */
		 pDao.deleteById(id);
		
	}

	

	
}
