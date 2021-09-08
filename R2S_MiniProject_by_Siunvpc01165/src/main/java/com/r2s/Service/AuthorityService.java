package com.r2s.Service;

import java.util.List;

import com.r2s.Entity.Authority;



public interface AuthorityService {

	public List<Authority> findAll();

	public List<Authority> findAuthoritiesOfAdministrators();

	public Authority create(Authority auth);

	public void delete(Integer id);

}
