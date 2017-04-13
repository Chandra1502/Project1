package com.niit.ecommercebackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ecommercebackend.model.Supplier;

@Repository(value="supplierDAO")
@EnableTransactionManagement
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrUpdate(Supplier supplier) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(supplier);
		tx.commit();
		return true;
	}

}
