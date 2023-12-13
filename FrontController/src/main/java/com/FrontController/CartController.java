package com.FrontController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.FrontController.Service.CartLinesServices;

@Controller
@RequestMapping(value="/cart")
public class CartController 
{

	@Autowired
	CartLinesServices cartlinesService;
	
	@RequestMapping(value="/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result)
	{
		ModelAndView mv = new ModelAndView("index");
		
		if(result != null)
		{
				switch(result) 
				{
					case "added":
						mv.addObject("message", "Product has been successfully added to cart!");
						break;
					case "deleted":
						mv.addObject("message", "Product has been successfully removed from cart!");
						break;
					case "updated":
						mv.addObject("message", "Product has been successfully updated!");
						break;
					case "maxcountreach":
						mv.addObject("message", "Quantity Cannot be greater than the available product quantity!!");
						break;
					case "mincountreach":
						mv.addObject("message", "Quantity Cannot be less than One!!");
						break;
					case "modified":
						mv.addObject("message", "Product has been modified successfully!!");
						break;
				}
		}
		
		mv.addObject("userclickshowcart",true);
		mv.addObject("cartlines" , cartlinesService.getCartLines());
		mv.addObject("title" , "Online Shopping - User Cart");
		
		return mv;
	}
	
	
	@RequestMapping(value="/add/{id}/product")
	public String addCartProduct(@PathVariable("id") int p_id)
	{
		String result = cartlinesService.addCartLineProduct(p_id);
		return "redirect:/cart/show?"+result;
	}
	
	@RequestMapping("/{cartLineId}/remove")
	public String removeCartLine(@PathVariable int cartLineId) {
		String response = cartlinesService.removeCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping("/{cartLineId}/update")
	public String updateCartLine(@PathVariable int cartLineId , @RequestParam(name = "count", required = false) int count) {
		String response = cartlinesService.updateCartLine(cartLineId , count);
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping("/validate")
	public String validateCartLine() {
		String response = cartlinesService.validate();
		if(response.equals("modified"))
			return "redirect:/cart/show?"+response;
		else
			return "redirect:/cart/checkout";
	}
	
	
}
