package com.niit.ecommercebackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ecommercebackend.model.User;

@Repository(value="userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrUpdate(User user) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(user);
		tx.commit();
		return true;
	}
	
	

}
