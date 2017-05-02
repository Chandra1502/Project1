package com.niit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.model.User;

public class UserTestCase {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User user;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}

	@Test
	public void test() {
		/*user.setUsername("user2");
		user.setPassword("abcde");
		user.setAddress("Hyderabad");
		user.setEmailid("chandu.pcv@gmail.com");
		user.setEnabled("true");
		user.setRole("User");
		user.setPhno("9876543210");
		boolean b = userDAO.saveOrUpdate(user);
		assertEquals("Saved",true,b);*/
	}

}
