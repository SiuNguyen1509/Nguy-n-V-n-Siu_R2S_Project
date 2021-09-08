package com.r2s.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r2s.DAO.RoleDAO;
import com.r2s.Entity.Role;
import com.r2s.Service.RoleService;
@Service
public class RoleImpl implements RoleService {
	@Autowired
	RoleDAO dao ;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
