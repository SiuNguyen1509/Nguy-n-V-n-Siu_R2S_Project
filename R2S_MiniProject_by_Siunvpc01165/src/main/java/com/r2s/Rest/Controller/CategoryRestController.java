package com.r2s.Rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.Entity.Category;
import com.r2s.Entity.Product;
import com.r2s.Service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
@Autowired
CategoryService cateservice;

@GetMapping()
public List<Category> getAll(){
	return  cateservice.findAll();
}

@GetMapping("{id}")
public Category getOne(@PathVariable("id") Integer id) {
	return cateservice.findById(id);
	
}
@PostMapping
public Category create(@RequestBody Category category) {
	return cateservice.create(category);
}

}
