package com.niit.ecommercebackend.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
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
			sessionFactory.openSession().save(cartItem);
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
		Query query=sessionFactory.openSession().createQuery("FROM CartItem where cartid=:id");
		query.setParameter("id",id);
		//return sessionFactory.getCurrentSession().createQuery("FROM CartItem where CARTID=:id", CartItem.class).setParameter("id", id).getResultList();
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
		return (CartItem) sessionFactory.getCurrentSession().get(CartItem.class, id);
	}

	@Override
	public boolean deleteAll(int cart_id) {
		try
		{
		Query q=sessionFactory.getCurrentSession().createQuery("delete from CartItem where cartid=:id");
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
		Query q=sessionFactory.getCurrentSession().createQuery("from CartItem where cartid=:cartid and product_product_id=:productid");
		q.setParameter("cartid", cart_id);
		q.setParameter("productid", product_id);
		
		try{
		
		return (CartItem)q.list();
			
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
			sessionFactory.openSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

}
