package com.niit.ecommercebackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommercebackend.model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public CartItemDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try
		{
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(cartItem);
			tx.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<CartItem> getAll(int id) {
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query query=s.createQuery("FROM CartItem where cart_cartid=:id");
		query.setParameter("id",id);
		t.commit();
		return query.list();
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		try{
			sessionFactory.openSession().delete(cartItem);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public CartItem getCartItem(int id) {
		return (CartItem) sessionFactory.openSession().get(CartItem.class, id);
	}

	@Override
	public boolean deleteAll(int cart_id) {
		try
		{
		Query q=sessionFactory.getCurrentSession().createQuery("delete from CartItem where cart_cartid=:id");
		q.setParameter("id", cart_id);
		q.executeUpdate();
		return true;
		}
		catch(Exception e){
			System.out.println(e);
		return false;
		}

	}

	@Override
	public CartItem getExistingCartItemCount(int product_id, int cart_id) {
		Query q=sessionFactory.openSession().createQuery("from CartItem where cart_cartid=:cartid and product_product_id=:productid");
		q.setParameter("cartid", cart_id);
		q.setParameter("productid", product_id);
		
		try{
		
		return (CartItem)q.uniqueResult();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.beginTransaction();
			s.update(cartItem);
			t.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

}