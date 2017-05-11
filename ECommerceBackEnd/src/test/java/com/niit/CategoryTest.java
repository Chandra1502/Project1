package com.niit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommercebackend.dao.CategoryDAO;
import com.niit.ecommercebackend.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		/*CategoryDAO categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		Category category = (Category)context.getBean("category");
		category.setCategory_name("Android");
		category.setCategory_description("Welcome to the world of Android");
		categoryDAO.saveOrUpdate(category);
		//categoryDAO.delete(category);
		System.out.println("Deleted");*/

	}

}
