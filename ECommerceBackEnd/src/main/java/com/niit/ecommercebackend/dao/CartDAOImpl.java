package com.niit.ecommercebackend.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommercebackend.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addCart(Cart cart) {
		try{
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(cart);
		tx.commit();
		return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try{
			System.out.println("updating cart with id"+ cart.getCartid());
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(cart);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean resetCart(int id) {
		System.out.println("Cart id"+id);
		Query q=sessionFactory.getCurrentSession().createQuery("update Cart set grandtotal=:total, quantity=:quan where cartid=:id");
		q.setParameter("total", 0);
		q.setParameter("quan", 0);
		q.setParameter("id", id);
		int i = q.executeUpdate();
		System.out.println("updated cart i value"+i);
		return true;
	}

	@Override
	public Cart getCart(int id) {
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("from Cart where cartid=:id");
		q.setParameter("id", id);
		t.commit();
		return (Cart) q.uniqueResult();
	}

}