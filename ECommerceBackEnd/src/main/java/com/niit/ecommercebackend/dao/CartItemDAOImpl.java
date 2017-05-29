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

import com.niit.ecommercebackend.model.CartItem;

@Repository("cartItemDAO")
@EnableTransactionManagement
public class CartItemDAOImpl implements CartItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public CartItemDAOImpl() {
		super();
	}

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			System.out.println("addCartItem successful");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in addCartItem");
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public List<CartItem> getAll(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from CartItem", CartItem.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional
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
	@Transactional
	public CartItem getCartItem(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from CartItem where cartitemid=:id", CartItem.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional
	public boolean deleteAll(int cart_id) {
		try
		{
		return true;
		}
		catch(Exception e){
			System.out.println(e);
		return false;
		}

	}

	@Override
	@Transactional
	public CartItem getExistingCartItemCount(int product_id, int cart_id) {
		try{
		return sessionFactory.getCurrentSession().createQuery("from CartItem where cart_cartid=:cartid and product_product_id=:productid",CartItem.class)
				.setParameter("cartid", cart_id).setParameter("productid", product_id).getSingleResult();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

}