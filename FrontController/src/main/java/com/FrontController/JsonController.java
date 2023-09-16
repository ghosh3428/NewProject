package com.FrontController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.DAO.ProductDAO;
import com.backend.model.Product;


@Controller
public class JsonController 
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/json/data/all/active/product")
	@ResponseBody
	public List<Product> getActiveproduct()
	{
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping(value="/json/data/category/{id}/product")
	@ResponseBody
	public List<Product> getcategoryproduct(@PathVariable("id") int category_id)
	{
		return productDAO.listActiveProductsByCategory(category_id);
	}
		
	@RequestMapping(value="/json/data/all/product")
	@ResponseBody
	public List<Product> getAllproduct()
	{
		return productDAO.productList();
	}
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		return productDAO.listActiveProductsByCategory(id);
	}
	
	
}
