package com.niit.ecommercebackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
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
	
	// Method to save or update the supplier object in the Database
	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	// Method to delete the supplier object from the Database
	@Override
	@Transactional
	public boolean delete(Supplier supplier) {
		
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	// Method to retrieve the supplier object from the Database using the supplier id
	@Override
	@Transactional
	public Supplier get(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Supplier where supplier_id=:id", Supplier.class).setParameter("id", id).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	// Method to retrieve all the supplier objects from the Database
	@Override
	@Transactional
	public List<Supplier> list() {
		try{
			return sessionFactory.getCurrentSession().createQuery("from Supplier", Supplier.class).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	

}
