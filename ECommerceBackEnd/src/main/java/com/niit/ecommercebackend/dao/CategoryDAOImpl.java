package com.niit.ecommercebackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommercebackend.model.Category;

@Repository(value="categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	// Method to save or update the category object in the Database
	@Transactional
	public boolean saveOrUpdate(Category category) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	// Method to delete the category object from the Database
	@Transactional
	public boolean delete(Category category) {
		
		try{
			sessionFactory.getCurrentSession().delete(category);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	// Method to retrieve the category object from the Database using the category id
	@Override
	@Transactional
	public Category get(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Category where category_id=:id", Category.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	// Method to retrieve all the category objects from the Database
	@Override
	@Transactional
	public List<Category> list() {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

		
}
