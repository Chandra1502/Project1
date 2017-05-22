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
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(category);
		tx.commit();
		return true;
	}
	
	public boolean delete(Category category) {
		
		try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.delete(category);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Category get(int id) {
		String hql = "from Category where category_id= " + id;
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query query = s.createQuery(hql);
		List<Category> list = query.list();
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
	public List<Category> list() {
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		String hql = "from Category";
		Query query = s.createQuery(hql);
		
		System.out.println("Starting of the method List");
		List<Category> list = query.list();
		
		if(list==null||list.isEmpty())
		{
			System.out.println("No categories are available");
		}
		t.commit();
		return query.list();
	}

}
