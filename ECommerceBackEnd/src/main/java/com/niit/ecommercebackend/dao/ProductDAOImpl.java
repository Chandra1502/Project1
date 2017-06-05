package com.niit.ecommercebackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommercebackend.model.Product;

@Repository(value="productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Method to save or update the product object in the Database
	@Override
	@Transactional
	public boolean saveOrUpdate(Product product) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
	// Method to delete the user object from the Database
	@Override
	@Transactional
	public boolean delete(Product product) {
		try{
			sessionFactory.getCurrentSession().delete(product);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	// Method to retrieve the product object from the Database using the product id
	@Override
	@Transactional
	public Product get(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Product where product_id=:id", Product.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	// Method to retrieve all the product objects from the Database
	@Override
	@Transactional
	public List<Product> list() {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

}
