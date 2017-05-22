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
		// TODO Auto-generated constructor stub
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
			/*System.out.println("in the addcartitem");
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(cartItem);
			tx.commit();*/
			
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
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
		/*Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query query=s.createQuery("FROM CartItem where cart_cartid=:id");
		query.setParameter("id",id);
		t.commit();
		return query.list();*/
		
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
	public boolean deleteAll(int cart_id) {
		try
		{
		/*Query q=sessionFactory.getCurrentSession().createQuery("delete from CartItem where cart_cartid=:id");
		q.setParameter("id", cart_id);
		q.executeUpdate();*/
		return true;
		}
		catch(Exception e){
			System.out.println(e);
		return false;
		}

	}

	@Override
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
	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			/*Session s = sessionFactory.openSession();
			Transaction t = s.beginTransaction();
			s.update(cartItem);
			t.commit();*/
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