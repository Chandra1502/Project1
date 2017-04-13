package com.niit.ecommercebackend.dao;

import com.niit.ecommercebackend.model.Category;

public interface CategoryDAO {
	
	public boolean saveOrUpdate(Category category);
}
