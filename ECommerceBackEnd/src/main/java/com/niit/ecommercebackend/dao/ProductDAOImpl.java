package com.niit.ecommercebackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

	@Override
	public boolean saveOrUpdate(Product product) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(product);
		tx.commit();
		return true;
	}

	@Override
	public boolean delete(Product product) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(product);
		tx.commit();
		return true;
	}

}
