package com.niit.ecommercebackend.dao;

import java.util.List;

import org.hibernate.Query;
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
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(user);
		tx.commit();
		return true;
	}

	
	public boolean delete(User user) {
		try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User get(String email) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		
		String str = "from User where emailid = '"+email+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(str);
		List<User> list = query.list();
		
		if(list != null && list.isEmpty()){
			tx.commit();
		}
		return list.get(0);
	}

	@Override
	public List<User> list() {
		String hql = "from User";
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery(hql);
		List<User> list = query.list();
		tx.commit();
		return list;
	}

	@Override
	public User getById(int id) {
		try{
			String hql = "from User where userid=" + id;
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery(hql);
			List<User> list = query.list();
			tx.commit();
			if(list==null)
				return null;
			else
				return list.get(0);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	

}
