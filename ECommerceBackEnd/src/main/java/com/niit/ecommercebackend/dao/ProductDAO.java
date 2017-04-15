package com.niit.ecommercebackend.dao;

import com.niit.ecommercebackend.model.Product;

public interface ProductDAO {
	
	public boolean saveOrUpdate(Product product);
	
	public boolean delete(Product product);
	
}
