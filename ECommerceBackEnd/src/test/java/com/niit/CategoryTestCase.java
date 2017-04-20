package com.niit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommercebackend.dao.CategoryDAO;
import com.niit.ecommercebackend.model.Category;

public class CategoryTestCase {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	@Autowired
	static Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}

	@Test
	public void test() {
		category.setCategory_name("Windows");
		category.setCategory_description("Open the Windows to explore more.");
		boolean b = categoryDAO.saveOrUpdate(category);
		assertEquals("Saved", true, b);
	}

}
