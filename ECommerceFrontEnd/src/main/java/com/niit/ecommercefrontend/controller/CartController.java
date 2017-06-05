package com.niit.ecommercefrontend.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.ecommercebackend.dao.CartDAO;
import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.model.Cart;
import com.niit.ecommercebackend.model.User;

@Controller
public class CartController {
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	/*@ModelAttribute
	public Cart returnCart()
	{
		return new Cart();
	}*/
	
	@RequestMapping("/cart")
	public String showCartDetails() {
		return "MyCart";
	}
	
	@RequestMapping("/cartdetails")
	public @ResponseBody Cart cartDetails(Principal principal) {
		System.out.println("cart details");
		User user = userDAO.get(principal.getName());
		Integer x = user.getUserid();
		return cartDAO.getCartWithUserId(x);
	}

}
