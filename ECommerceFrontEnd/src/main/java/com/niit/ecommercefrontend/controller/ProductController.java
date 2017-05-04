package com.niit.ecommercefrontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommercebackend.dao.CategoryDAO;
import com.niit.ecommercebackend.dao.ProductDAO;
import com.niit.ecommercebackend.dao.SupplierDAO;
import com.niit.ecommercebackend.model.Category;
import com.niit.ecommercebackend.model.Product;
import com.niit.ecommercebackend.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	Supplier supplier;

	@Autowired
	Category category;

	@Autowired
	Product product;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	CategoryDAO categoryDAO;
	
	@ModelAttribute
	public Product returnObject()
	{
		return new Product();
	}
	
	@RequestMapping("/AddProduct")
	public ModelAndView showProducts()
	{
		ModelAndView mv= new ModelAndView("AddProduct");
		mv.addObject("productList", productDAO.list());
		mv.addObject("categoryList",categoryDAO.list());
		mv.addObject("supplierList",supplierDAO.list());
		return mv;
	}
	
	@RequestMapping(value="/addprod",method=RequestMethod.POST)
	public String addprod(@Valid @ModelAttribute("product")Product product, BindingResult result, Model model,HttpServletRequest request) throws IOException
	{
		model.addAttribute("product",new Product());
		
		System.out.println(product.getProduct_name());
		System.out.println("image uploaded");
		System.out.println("myproduct controller called");
		MultipartFile image = product.getImage();
		
		Path path;
		path = Paths.get("C:/Users/Harsha/git4/ECommerceFrontEnd/src/main/webapp/resources/images/" + product.getProduct_name() +".jpg");
		System.out.println("Path=" + path);
		System.out.println("File name" + product.getImage().getOriginalFilename());
		
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");
			}
		}

		if(product.getProduct_id()==0)
		{
			productDAO.saveOrUpdate(product);
			System.out.println("product added");
		}
		else
		{
			productDAO.saveOrUpdate(product);
			System.out.println("product updated");
			return "AddProduct";
		}
		
		HttpSession session=request.getSession(false);
		String username=(String)session.getAttribute("LoggedInUser");
		model.addAttribute("message", "product added successfully");
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());

		return "redirect:/AddProduct";
	}
	
	@RequestMapping(value="/editproducts{id}")
	public ModelAndView updateProduct(@PathVariable("id")String id,Model model)
	{
	int i=Integer.parseInt(id);
	model.addAttribute("product", productDAO.get(i));
	model.addAttribute("productList", productDAO.list());
	ModelAndView mv=new ModelAndView("AddProduct");
	return mv;
	}
	
	@RequestMapping(value="/deleteproduct{id}")
	public ModelAndView deleteProduct(@PathVariable("id")String id,Model model)
	{
	int i=Integer.parseInt(id);
	product= productDAO.get(i);
	productDAO.delete(product);
	model.addAttribute("productList", productDAO.list());
	ModelAndView mv=new ModelAndView("AddProduct");
	mv.addObject("AddProduct", 0);
	return mv;
	}
	
	
}
