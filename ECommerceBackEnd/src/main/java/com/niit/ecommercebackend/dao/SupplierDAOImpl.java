package com.niit.ecommercebackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	@Transactional
	public boolean delete(Supplier supplier) {
		
		try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.delete(supplier);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Supplier get(int id) {
		String hql = "from Supplier where supplier_id= " + id;
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query query = s.createQuery(hql);
		List<Supplier> list = query.list();
		if(list == null || list.isEmpty())
		{
			System.out.println("No products are available with this id: "+id);
			return null;
		}
		else
			return list.get(0);
	}

	@Override
	@Transactional
	public List<Supplier> list() {
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		String hql = "from Supplier";
		Query query = s.createQuery(hql);
		
		System.out.println("Starting of the method List");
		List<Supplier> list = query.list();
		
		if(list==null||list.isEmpty())
		{
			System.out.println("No suppliers are available");
		}
		t.commit();
		return query.list();
	}
	
	

}
