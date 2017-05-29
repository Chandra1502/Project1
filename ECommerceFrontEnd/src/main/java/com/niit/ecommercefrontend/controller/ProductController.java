package com.niit.ecommercefrontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommercebackend.dao.CartDAO;
import com.niit.ecommercebackend.dao.CartItemDAO;
import com.niit.ecommercebackend.dao.CategoryDAO;
import com.niit.ecommercebackend.dao.ProductDAO;
import com.niit.ecommercebackend.dao.SupplierDAO;
import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.model.Cart;
import com.niit.ecommercebackend.model.CartItem;
import com.niit.ecommercebackend.model.Category;
import com.niit.ecommercebackend.model.Product;
import com.niit.ecommercebackend.model.Supplier;
import com.niit.ecommercebackend.model.User;

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

	@Autowired
	UserDAO userDAO;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	CartItemDAO cartItemDAO;

	@Autowired
	HttpSession session;

	@ModelAttribute
	public Product returnObject() {
		return new Product();
	}

	@RequestMapping("/Product")
	public String showDetails(Model mp) {
		return "Product";
	}

	@RequestMapping("/AddProduct")
	public ModelAndView showProducts() {
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("productList", productDAO.list());
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}

	@RequestMapping(value = "/addprod", method = RequestMethod.POST)
	public String addprod(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
			HttpServletRequest request) throws IOException {
		model.addAttribute("product", new Product());

		System.out.println(product.getProduct_name());
		System.out.println("image uploaded");
		System.out.println("myproduct controller called");
		MultipartFile image = product.getImage();

		Path path;
		path = Paths.get("C:/Users/Harsha/git4/ECommerceFrontEnd/src/main/webapp/resources/images/"
				+ product.getProduct_name() + ".jpg");
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

		if (product.getProduct_id() == 0) {
			productDAO.saveOrUpdate(product);
			System.out.println("product added");
		} else {
			productDAO.saveOrUpdate(product);
			System.out.println("product updated");
		}

		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("LoggedInUser");
		model.addAttribute("message", "product added successfully");
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());

		return "AddProduct";
	}

	@RequestMapping(value = "/editproducts{id}")
	public ModelAndView updateProduct(@PathVariable("id") String id, Model model) {
		int i = Integer.parseInt(id);
		model.addAttribute("product", productDAO.get(i));
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());
		ModelAndView mv = new ModelAndView("AddProduct");
		return mv;
	}

	@RequestMapping(value = "/deleteproduct{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id, Model model) {
		int i = Integer.parseInt(id);
		product = productDAO.get(i);
		productDAO.delete(product);
		model.addAttribute("productList", productDAO.list());
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("AddProduct", 0);
		return mv;
	}

	@RequestMapping("/{id}/ViewDetails")
	public String showDetails(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("product", productDAO.get(id));
		return "ViewDetails";
	}

	@RequestMapping("/allproducts")
	public @ResponseBody List<Product> productsall() {
		System.out.println("inside products all");
		return productDAO.list();
	}

	@RequestMapping("/{id}/addcart")
	public String addCart(@PathVariable Integer id, Principal principal) {
		User user = userDAO.get(principal.getName());
		user.setConfirmpassword(user.getPassword());
		Product product = productDAO.get(id);
		System.out.println(product);
		Cart cart = cartDAO.getCartWithUserId(user.getUserid());
		
		if(cart!=null)
	     {
			System.out.println("Cart is not null and can be updated");
	    	 cart.setUser(user);
	    		
	    	CartItem cartItem=cartItemDAO.getExistingCartItemCount(id, cart.getCartid());
	    	if(cartItem!=null)
	    	{
	    		cartItem.setCart(cart);
	    		cartItem.setGrandtotal(cartItem.getGrandtotal()+product.getProduct_price());
	    		cartItem.setQuantity(cartItem.getQuantity()+1);
	    		cartItemDAO.updateCartItem(cartItem);
	    	}
	    	else{
	    		cartItem=new CartItem();
	    		cartItem.setCart(cart);
	    		cartItem.setGrandtotal(product.getProduct_price());
	    		cartItem.setProduct(product);
	    		cartItem.setQuantity(1);
	    		cartItemDAO.addCartItem(cartItem);
	    	}
	    	cart.setGrandtotal(cart.getGrandtotal()+product.getProduct_price());
	    	cart.setQuantity(cart.getQuantity()+1);
	    	List<CartItem> cartItems=cart.getCartitems();
	    	cartItems.add(cartItem);
	    	cart.setCartitems(cartItems);
	    	cartDAO.updateCart(cart);
	    	
	     }
		else
	     {
	    	 System.out.println("Cart is null and is ready to be created");
	    	 cart=new Cart();
	    	 cart.setGrandtotal(product.getProduct_price());
	    	 cart.setQuantity(1);
	    	 cart.setUser(user);
	    	 CartItem cartItem=new CartItem();
	    	 cartItem.setCart(cart);
	    	 cartItem.setGrandtotal(product.getProduct_price());
	    	 cartItem.setProduct(product);
	    	 cartItem.setQuantity(1);
	    	 
	    	 cartDAO.addCart(cart);
	    	 System.out.println("addCart completed in product Controller");
	    	 cartItemDAO.addCartItem(cartItem);
	    	 System.out.println("addCartItem completed in product Controller");
	     }
	     
	     //model.addAttribute("mycartList", cartItemDAO.getAll(id));
	return "MyCart";
}

}