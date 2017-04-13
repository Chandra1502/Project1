package com.niit.ecommercebackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

	public boolean saveOrUpdate(Category category) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(category);
		tx.commit();
		return true;
	}

}
