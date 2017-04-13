package com.niit.ecommercebackend.dao;

import com.niit.ecommercebackend.model.User;

public interface UserDAO {
	
	public boolean saveOrUpdate(User user);
}
