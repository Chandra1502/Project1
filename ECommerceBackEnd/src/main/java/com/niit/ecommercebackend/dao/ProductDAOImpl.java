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
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(product);
		tx.commit();
		return true;
	}

	@Override
	public boolean delete(Product product) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(product);
		tx.commit();
		return true;
	}

	@Override
	public Product get(int id) {
		String hql = "from Product where product_id= " + id;
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query query = s.createQuery(hql);
		List<Product> list = query.list();
		t.commit();
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
	public List<Product> list() {
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		String hql = "from Product";
		Query query = s.createQuery(hql);
		
		System.out.println("Starting of the method List");
		List<Product> list = query.list();
		
		if(list==null||list.isEmpty())
		{
			System.out.println("No products are available");
		}
		t.commit();
		return query.list();
	}

}
