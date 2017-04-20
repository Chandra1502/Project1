package com.niit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommercebackend.dao.SupplierDAO;
import com.niit.ecommercebackend.model.Supplier;

public class SupplierTestCase {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	static SupplierDAO supplierDAO;
	
	@Autowired
	static Supplier supplier;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}

	@Test
	public void test() {
		supplier.setSupplier_name("Green Mobiles");
		supplier.setSupplier_location("Hyderbad");
		boolean b = supplierDAO.saveOrUpdate(supplier);
		assertEquals("Saved", true, b);
	}

}
