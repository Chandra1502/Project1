package com.niit.ecommercefrontend.controller;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommercebackend.dao.CartDAO;
import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.model.Supplier;
import com.niit.ecommercebackend.model.User;



@Controller
public class HomeController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	SessionFactory sessionFactory;
	
	// OS Mappings
	
	@RequestMapping("/Android")
	public String showAndroid()
	{
		return "Android";
	}
	
	@RequestMapping("/IOS")
	public String showIOS()
	{
		return "IOS";
	}
	
	@RequestMapping("/Windows")
	public String showWindows()
	{
		return "Windows";
	}
	
	@RequestMapping("/BlackBerry")
	public String showBlackBerry()
	{
		return "BlackBerry";
	}
	// OS Mapping Completed
	
	
	
	// Home Page Mappings
	@RequestMapping("/")
	public String showHome()
	{
		return "Home";
	}
	
	@RequestMapping("/AboutUs")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/Home")
	public String showHomeOnImage()
	{
		return "Home";
	}
	
	@RequestMapping("/Login")
	public String showLogin()
	{
		return "Login";
	}
	
	@RequestMapping("/AdminHome")
	public String showAdminHome()
	{
		return "AdminHome";
	}
	
	@RequestMapping("/Logout")
	public String showLogout()
	{
		return "Logout";
	}
	
	@RequestMapping("/Signup")
	public ModelAndView showsignup()
	{
		ModelAndView mv= new ModelAndView("Signup");
		return mv;
	}	
	// Home page Mappings Completed
	
	// Login Mapping
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session, Model model, @RequestParam(value="username") String id){
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		System.out.println("inside security check");
		
		session.setAttribute("name", name);
		
		user = userDAO.get(id);
		int x = user.getUserid();
		session.setAttribute("email", user.getEmailid());
		session.setAttribute("LoggedInUser", user.getUsername());
		session.setAttribute("LoggedInUserID", x);
		session.setAttribute("LoggedIn", "true");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role = "ROLE_USER";
		for(GrantedAuthority authority : authorities){
			if(authority.getAuthority().equals(role)){
				return "Product"; 
			}
			else{
				session.setAttribute("isAdmin", "true");
			}
		}
		return "AdminHome";
	}
	
	// Logout Mapping
	@RequestMapping("/perform_logout")
	public ModelAndView showLogout(HttpServletRequest request, HttpSession session){
		System.out.println("logout");
		ModelAndView mv = new ModelAndView("Logout");
		session.setAttribute("LogOutMessage","You have Successfully Logged Out.");
		session.invalidate();
		session = request.getSession(true);
		mv.addObject("LogOutMessage","You have Successfully Logged Out.");
		mv.addObject("loggedOut","true");
		return mv;
	}
	
	
	@ModelAttribute
	public User returnObject()
	{
		return new User(); 
	}
	 //After clicking submit this page with data is opened and is sent to addus page
	@RequestMapping(value = "/addus", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request)
	{
		System.out.print(user.getConfirmpassword());
		System.out.println(user.getPassword());

		user.setEnabled("true");
		user.setRole("ROLE_USER");

		if (user.getConfirmpassword().equals(user.getPassword()));
		{
			userDAO.saveOrUpdate(user);
		}
		
		return "Login";
	}
}


 

