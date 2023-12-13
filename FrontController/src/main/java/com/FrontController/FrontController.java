package com.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backend.DAO.CategoryDAO;

@Controller
public class FrontController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping(value={"/index","/home","/"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","ONLINE SHOPPING - INDEX");
		mv.addObject("welcome","Hello User!!! Welcome to ONLINE SHOPPING HOME PAGE");
		mv.addObject("userclickhome" , true);
		mv.addObject("categorylist" , categoryDAO.activeCategoryList());
		return mv;
	}
	
	
	@RequestMapping(value="/aboutus")
	public ModelAndView aboutus()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","ONLINE SHOPPING - ABOUT US");
		mv.addObject("welcome","Hello User!!! Welcome to ONLINE SHOPPING ABOUT US PAGE");
		mv.addObject("userclickaboutus" , true);
		
		return mv;
	}
	
	@RequestMapping(value="/contactus")
	public ModelAndView contactus()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","ONLINE SHOPPING - CONTACT US");
		mv.addObject("welcome","Hello User!!! Welcome to ONLINE SHOPPING CONTACT US PAGE");
		mv.addObject("userclickcontactus" , true);
		
		return mv;
	}
	
	@RequestMapping(value = "/custom-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    
	    return "redirect:/login?logout";
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,@RequestParam(name="logout", required = false)	String logout)
	{
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title" , "Online Shopping - LOGIN");
		
		if(error!= null) 
		{
			mv.addObject("message", "Username and Password is invalid!");
		}
		
		if(logout!= null) 
		{
			mv.addObject("logout", "You have successfully logged out.");
		}
		return mv;
	}
	

}
