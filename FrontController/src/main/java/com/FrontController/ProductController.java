package com.FrontController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backend.DAO.CategoryDAO;
import com.backend.DAO.ProductDAO;


@Controller
@RequestMapping(value="/product")
public class ProductController 
{
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value="/show/all/active/product")
	public ModelAndView showActiveProduct()
	{
		ModelAndView mv = new ModelAndView("index");
		
		
		mv.addObject("title" , "ONLINE SHOPPING - All Active Products");
		mv.addObject("userclickallactiveproduct" , true);
		mv.addObject("categorylist" , categoryDAO.activeCategoryList());
		mv.addObject("productlist" , productDAO.listActiveProducts());
		
		return mv;
		
		
	}
	@RequestMapping(value="/show/category/{id}/product")
	public ModelAndView showcategoryProduct(@PathVariable("id") int category_id)
	{
		ModelAndView mv = new ModelAndView("index");
		
		
		mv.addObject("title" , "ONLINE SHOPPING - All Active Products");
		mv.addObject("userclickcategoryproduct" , true);
		mv.addObject("category" , categoryDAO.get(category_id));
		mv.addObject("categorylist" , categoryDAO.activeCategoryList());
		mv.addObject("productlist" , productDAO.listActiveProductsByCategory(category_id));
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int product_id)
	{
		ModelAndView mv = new ModelAndView("index");
		
		
		mv.addObject("title" , "ONLINE SHOPPING - Single Product");
		mv.addObject("userclicksingleproduct" , true);
		mv.addObject("product" , productDAO.getProduct(product_id));
		
		return mv;
		
		
	}
}
