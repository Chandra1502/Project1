package com.niit.ecommercebackend.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommercebackend.model.Cart;

@EnableTransactionManagement
@Repository("cartDAO")

public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDAOImpl() {
		super();
	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean addCart(Cart cart) {
		try{
		sessionFactory.getCurrentSession().save(cart);
		System.out.println("addCart successful");
		return true;
		}
		catch(Exception e){
			System.out.println("Exception in addCart");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateCart(Cart cart) {
		try{
			System.out.println("updating cart with id"+ cart.getCartid());
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean resetCart(int id) {
		System.out.println("Cart id"+id);
		try{
		Cart cart = getCart(id);
		cart.setGrandtotal(0);
		cart.setQuantity(0);
		updateCart(cart);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public Cart getCart(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Cart where catid=:id", Cart.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public Cart getCartWithUserId(Integer id) {
		try{
			
			return sessionFactory.getCurrentSession().createQuery("from Cart where user_userid=:id", Cart.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e){
			System.out.println("Exception in getCartWithUserId of CartDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

}