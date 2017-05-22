package com.niit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommercebackend.dao.CartDAO;
import com.niit.ecommercebackend.dao.CartItemDAO;
import com.niit.ecommercebackend.dao.ProductDAO;
import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.model.Cart;
import com.niit.ecommercebackend.model.CartItem;
import com.niit.ecommercebackend.model.Product;

public class CartTestCase {
	
	/*private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private static CartDAO cartDAO;
	private static ProductDAO productDAO;
	private static CartItemDAO cartItemDAO;
	private Cart cart;
	private CartItem cartItem;
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO = (CartDAO)context.getBean("cartDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		cartItemDAO = (CartItemDAO)context.getBean("cartItemDAO");
	}

	@Test
	public void test() {
		product=productDAO.get(33);
		cart = new Cart();
		cart.setGrandtotal(product.getProduct_price());
		cart.setQuantity(1);
		cart.setUser(userDAO.get("user@gmail.com"));
		cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setGrandtotal(product.getProduct_price());
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		List<CartItem> cartItems = new ArrayList<CartItem>();
		cartItems.add(cartItem);
		cart.setCartitems(cartItems);
		
		assertEquals("success", true, cartDAO.addCart(cart));
		assertEquals("success", true, cartItemDAO.addCartItem(cartItem));
	}*/

}
