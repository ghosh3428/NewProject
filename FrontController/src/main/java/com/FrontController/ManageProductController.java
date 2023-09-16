package com.FrontController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Frontend.FrontController.util.FileUploader;
import com.Frontend.FrontController.validate.ProductValidate;
import com.backend.DAO.CategoryDAO;
import com.backend.DAO.ProductDAO;
import com.backend.DAO.UserDAO;
import com.backend.model.Category;
import com.backend.model.Product;
import com.backend.model.User;

@Controller
@RequestMapping(value = "/manage")
public class ManageProductController {
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/product")
	public ModelAndView manageProduct(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("userclickmanageproduct", true);
		mv.addObject("title", "Online Shopping - Manage Product");

		Product newProduct = new Product();
		newProduct.setActive(true);

		mv.addObject("product", newProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product added successfully!");
			}
			if (operation.equals("category")) {
				mv.addObject("message", "Category added successfully!");
			}
		}

		return mv;
	}

	@RequestMapping(value = { "manage/{id}/product" })
	public ModelAndView editProduct(@PathVariable("id") int p_id) {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("product", productDAO.getProduct(p_id));

		mv.addObject("userclickmanageproduct", true);
		return mv;
	}

	@ModelAttribute("categoryList")
	public List<Category> getcategoryList() {
		return categoryDAO.activeCategoryList();
	}

	@ModelAttribute("category")
	public Category getcategory() {
		return new Category();
	}

	@ModelAttribute("supplierList")
	public List<User> getSupplierList() {
		return userDAO.getSupplierList();
	}

	@RequestMapping(value = "/manage/add/product")
	public String addProduct(@Valid @ModelAttribute("product") Product p, BindingResult results, Model model,
			HttpServletRequest request) {
		if (p.getId() == 0) {
			new ProductValidate().validate(p, results);
		} else {

			if (!(p.getFile().getOriginalFilename().equals("") || p.getFile() == null)) {
				new ProductValidate().validate(p, results);
			}

		}

		if (results.hasErrors()) {

			model.addAttribute("userclickmanageproduct", true);
			return "index";
		}

		else {

			if (p.getId() == 0) {
				p.setActive(true);
				productDAO.addProduct(p);
			} else
				productDAO.updateProduct(p);

			if (!p.getFile().getOriginalFilename().equals("")) {
				FileUploader.uploadFile(request, p.getFile(), p.getCode());
			}

			return "redirect:/product?operation=product";
		}

	}

	@RequestMapping(value = "manage/add/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute("category") Category newCategory) {
		newCategory.setActive(true);
		categoryDAO.insert(newCategory);

		return "redirect:/product?operation=category";
	}

	@RequestMapping(value = "manage/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductAvtivation(@PathVariable int id) {
		Product product = productDAO.getProduct(id);

		boolean isActive = product.isActive();

		product.setActive(!isActive);

		productDAO.updateProduct(product);

		return (isActive) ? "Successfully Deactivated the product with id : " + product.getId()
				: "Successfully Activated the product with id : " + product.getId();
	}

}
