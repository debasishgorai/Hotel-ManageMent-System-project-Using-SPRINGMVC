package SpringBootApplication.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringBootApplication.dao.*;
import SpringBootApplication.entities.*;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;

	@Autowired
	HotelDao hotelDao;

	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		Product p = new Product();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("productform");
		return mav;
	}

	@RequestMapping("/saveproduct")
	//save handler entity into database
	public ModelAndView saveProduct(@ModelAttribute("productobj") Product p, HttpSession session) {
		Integer hotel_id = (Integer) session.getAttribute("hotelinfo");
		Hotel hotel = hotelDao.findById(hotel_id);
		List<Product> products = hotel.getProducts();
		if (products.size() > 0) {
			products.add(p);
			hotel.setProducts(products);
		} else {
			List<Product> productsList = new ArrayList<Product>();
			productsList.add(p);
			hotel.setProducts(productsList);
		}
		productDao.saveProduct(p);
		hotelDao.updateHotel(hotel);

		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Product added successfully");
		mav.setViewName("hoteloption.jsp");
		return mav;
	}

	@RequestMapping("/viewallproduct")
	//this handler is used to fetch all the products of particular hotel and submit to 
	//displayproduct.jsp
	public ModelAndView viewAllProduct(HttpSession session) {
		Integer hotel_id = (Integer) session.getAttribute("hotelinfo");
		Hotel hotel = hotelDao.findById(hotel_id);
		List<Product> products = productDao.findAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("fetchallobj", products);
		mav.setViewName("displayproducts");
		return mav;
	}

	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("id") int id) {
		Product product = productDao.findById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("existingProductInfo", product);
		mav.setViewName("updateproductform");
		return mav;
	}
	
	@RequestMapping("/updateproductinfo")
	public ModelAndView updateProductInfo(@ModelAttribute("existingProductInfo") Product p) {
		productDao.updateProduct(p);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Updated Successfully");
		mav.setViewName("redirect://viewallproduct");
		return mav;
	}
	
	@RequestMapping("/hotellogout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Logged out successfully");
		mav.setViewName("HotelHomePage");
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam("id") int id, HttpSession session) {
		Integer hotel_id = (Integer) session.getAttribute("hotelinfo");
		Hotel hotel = hotelDao.findById(hotel_id);
		List<Product> products = hotel.getProducts();
		
		List<Product> productList = products.stream().filter(product -> product.getId() != id)
				.collect(Collectors.toList());
		hotel.setProducts(productList);
		
		hotelDao.updateHotel(hotel);
		productDao.deleteById(id);
		
		
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("message", "Deleted sucessfully");
		mav.setViewName("redirect://viewallproduct");
		return mav;
		
	}
	


}
