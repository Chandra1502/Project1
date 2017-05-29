package com.niit.ecommercebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ecommercebackend.dao.CartDAO;
import com.niit.ecommercebackend.dao.CartDAOImpl;
import com.niit.ecommercebackend.dao.CartItemDAO;
import com.niit.ecommercebackend.dao.CartItemDAOImpl;
import com.niit.ecommercebackend.dao.CategoryDAO;
import com.niit.ecommercebackend.dao.CategoryDAOImpl;
import com.niit.ecommercebackend.dao.ProductDAO;
import com.niit.ecommercebackend.dao.ProductDAOImpl;
import com.niit.ecommercebackend.dao.SupplierDAO;
import com.niit.ecommercebackend.dao.SupplierDAOImpl;
import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.dao.UserDAOImpl;
import com.niit.ecommercebackend.model.Cart;
import com.niit.ecommercebackend.model.CartItem;
import com.niit.ecommercebackend.model.Category;
import com.niit.ecommercebackend.model.Product;
import com.niit.ecommercebackend.model.Supplier;
import com.niit.ecommercebackend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/Mobiles");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("Datasource");
		return datasource;
	}
	
	private Properties getHibernateProperties()
	{
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		//prop.put("hibernate.current_session_context_class","thread");
		System.out.println("Hibernate Properties");
		return prop;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory  getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		System.out.println("Session Factory");
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction Manager");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("user DAO");
		return new UserDAOImpl();
	}
	
	@Autowired
	@Bean(name="user")
	public User getUser()
	{
		System.out.println("user");
		return new User();
	}
	
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		System.out.println("product DAO");
		return new CategoryDAOImpl();
	}
	
	@Autowired
	@Bean(name="category")
	public Category getCategory()
	{
		System.out.println("category");
		return new Category();
	}
	
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		System.out.println("supplier DAO");
		return new SupplierDAOImpl();
	}
	
	@Autowired
	@Bean(name="supplier")
	public Supplier getSupplier()
	{
		System.out.println("supplier");
		return new Supplier();
	}
	
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		System.out.println("productDAO");
		return new ProductDAOImpl();
	}
	
	@Autowired
	@Bean(name="product")
	public Product getProduct()
	{
		System.out.println("product");
		return new Product();
	}
	
	@Autowired
	@Bean(name="cartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory)
	{
		System.out.println("cartDAO");
		return new CartDAOImpl();
	}
	
	@Autowired
	@Bean(name="cart")
	public Cart getCart()
	{
		System.out.println("cart");
		return new Cart();
	}
	
	@Autowired
	@Bean(name="cartItemDAO")
	public CartItemDAO getCartItemDAO(SessionFactory sessionFactory)
	{
		System.out.println("cartItemDAO");
		return new CartItemDAOImpl();
	}
	
	@Autowired
	@Bean(name="cartItem")
	public CartItem getCartItem()
	{
		System.out.println("cartItem");
		return new CartItem();
	}
	
}
