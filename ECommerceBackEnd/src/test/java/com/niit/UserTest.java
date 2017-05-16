package com.niit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.model.User;

public class UserTest {
	
		public static void main(String a[])
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			
			/*UserDAO userDAO=(UserDAO)context.getBean("userDAO");
			User user=(User)context.getBean("user");
			//user.setUserid(1);
			user.setUsername("user1");
			user.setPassword("abcd");
			user.setAddress("Hyderabad");
			user.setEmailid("chandu.pcv@gmail.com");
			user.setEnabled("true");
			user.setRole("Admin");
			user.setPhno("9876543210");
			userDAO.saveOrUpdate(user);
			System.out.println("User Test");*/
		}
}
