package com.niit.ecommercebackend.dao;

import java.util.List;

import com.niit.ecommercebackend.model.User;

public interface UserDAO {
	
	public boolean saveOrUpdate(User user);
	
	public boolean delete(User user);
	
	public User get(String email);
	
	public List<User> list();
	
	public User getById(int id);
	
}
